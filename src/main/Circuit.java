package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import nodes.Node;

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
		nodeLinks = nodeLinks.substring(0, nodeLinks.indexOf(';'));
		nodeLinks = nodeLinks.substring(nodeLinks.indexOf(":")+1, nodeLinks.length());
		nodeLinks = nodeLinks.replaceAll("NODE", "");
		if (nodeLinks.equals("Cout") || nodeLinks.equals("S")) {
			// TODO
		} else {
			if (nodeLinks.contains(",")) {
				String[] split = nodeLinks.split(",");
				nodeLinksArray = new ArrayList<String>(Arrays.asList(split));
			} else {
				nodeLinksArray.add(nodeLinks);
			}
			for (String link : nodeLinksArray) {
				int linkInt = Integer.parseInt(link)-1;
				nodeList.get(i).setObserver(nodeList.get(linkInt));
				System.out.println("Node " + i + " has observable: " + linkInt);
			}
			nodeList.get(i).setObserver(nodeList.get(i)); 
		}
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
                } else if(!s.contains("#") && s.contains("NODE") && s.charAt(0) == 'N' && !nodeCreation) {
                	setNodeObservers(s, i);
                	i++;
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
