package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import nodes.Node;
import nodes.Probe;

public class Circuit {
	
	private NodeFactory nodeFactory = new NodeFactory();
	private int carryIn, a, b;
	public int carryOut,sOut;	
	
	public Circuit(String fileName, int carryIn){
//		this.carryIn = carryIn; // TODO Alleen als carryin gezet is?
		readFile(fileName);
	}
	
	
	
	
	
	private void setNodeObservers(String nodeLinks, int i) {
		ArrayList<Node> nodeList = this.nodeFactory.getNodeList();
		ArrayList<String> nodeLinksArray = new ArrayList<String>();
		Input input = null;
		int inputValue = 0;
		boolean isInput = false;
		// Check if it is input
		if (nodeLinks.charAt(0) == 'C') {
			input = new Input();
			inputValue = this.carryIn;
		} else if (nodeLinks.charAt(0) == 'A') {
			input = new Input();
			inputValue = this.a;
		} else if (nodeLinks.charAt(0) == 'B') {
			input = new Input();
			inputValue = this.b;
		}
		if (nodeLinks.charAt(0) == 'C' || nodeLinks.charAt(0) == 'A' || nodeLinks.charAt(0) == 'B') {
			isInput = true;
			nodeLinksArray = nodeLinkCleaner(nodeLinks);
			return;
		}
		// Make an array of links to add
		nodeLinksArray = nodeLinkCleaner(nodeLinks);
		for (String link : nodeLinksArray) {
			if (!link.contains("Cout") && !link.contains("S") && !isInput) {
				int linkInt = Integer.parseInt(link)-1;
				nodeList.get(i).setObserver(nodeList.get(linkInt));
				System.out.println("Node " + (i+1) + " has observable: " + (linkInt+1));
			} else if (isInput) {
				int linkInt = Integer.parseInt(link)-1;
				input.setInput(inputValue);
				input.setObserver(nodeList.get(linkInt));
				input.update(input, inputValue);
			} else if (link.contains("Cout")) {
				System.out.println("Node " + (i+1) + " has observable: Cout");
			} else if (link.contains("S")) {
				System.out.println("Node " + (i+1) + " has observable: S");
			}
		}
	}
	
	private ArrayList<String> nodeLinkCleaner(String nodeLinks) {
		ArrayList<String> nodeLinksArray = new ArrayList<String>();
		nodeLinks = nodeLinks.substring(0, nodeLinks.indexOf(';'));
		nodeLinks = nodeLinks.substring(nodeLinks.indexOf(":")+1, nodeLinks.length());
		if (nodeLinks.charAt(0) == 'N') {
			nodeLinks = nodeLinks.replaceAll("NODE", "");
		}
		if (nodeLinks.contains(",")) {
			String[] split = nodeLinks.split(",");
			nodeLinksArray = new ArrayList<String>(Arrays.asList(split));
		} else {
			nodeLinksArray.add(nodeLinks);
		}
		return nodeLinksArray;
	}





	private void createNode (String type) {
		type = type.substring(0, type.indexOf(';'));
		type = type.substring(type.indexOf(":")+1, type.length());
		// nodeType (String) can be: AND, NAND, NOR, NOT, OR, XOR
		this.nodeFactory.createNode(type);
	}





	public boolean readFile(String fileName){
		try
        {
			FileReader fr = new java.io.FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s;
            int i = 0;
            boolean nodeCreation = true;
            while ((s = br.readLine()) != null)
            {
            	s = s.replaceAll("\\t", "").replaceAll("\\n", "").replaceAll(" ", "");
                if (!s.contains("#") && s.contains("NODE") && nodeCreation) {
	                createNode(s);
                } else if(!s.contains("#") && s.contains("A:") && nodeCreation) {
                	a = s.contains("INPUT_HIGH") ? 1 : 0;
                	System.out.println("A in is: "+a);
                } else if(!s.contains("#") && s.contains("B:") && nodeCreation) {
                	b = s.contains("INPUT_HIGH") ? 1 : 0;
                	System.out.println("B in is: "+b);
                } else if(!s.contains("#") && s.contains("Cin:") && nodeCreation) {
                	carryIn = s.contains("INPUT_HIGH") ? 1 : 0;
                	System.out.println("Carry in is: "+carryIn);
            	// Find the blank line to switch to node linking
                } else if("".equals(s.trim())) {
                	nodeCreation = false;
                // Not nodeCreation so it's time to link the nodes
                } else if(!s.contains("#") && s.contains("NODE") && !nodeCreation) {
                	setNodeObservers(s, i);
                	if (!s.contains("A") && !s.contains("B") && !s.contains("Cin")) {
                		i++;
                	}
                }
            }

            fr.close();
        }
        catch (FileNotFoundException e){ 
        	System.out.println("File: " + fileName + " does not exist. Exiting program."); System.exit(1); 
    	}
        catch (IOException e){ 
        	System.out.println("Failed to read file: " + fileName + ". Exiting program."); System.exit(1); 
    	}
	    return true;
	}

}
