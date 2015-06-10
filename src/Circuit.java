import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import nodes.Node;

public class Circuit {
	
	private NodeFactory nodeFactory = new NodeFactory();
	private ArrayList<String> lines;
	private int carryIn, a, b;
	public int carryOut,sOut;
	
	
	public Circuit(String fileName, int carryIn){
		this.carryIn = carryIn;
		readFile(fileName);
	}
	
	
	
	
	
	private void setNodeObserver() {
		
		ArrayList<Node> nodeList = this.nodeFactory.getNodeList();
		System.out.println(nodeList.size());
		
	}
	
	private void createNode (String type) {
		type = type.substring(0, type.indexOf(';'));
		type = type.substring(type.indexOf(":")+1, type.length());
		// nodeType (String) can be: AND, NAND, NOR, NOT, OR, XOR
		this.nodeFactory.createNode(type);
	}





	public boolean readFile(String fileName){
		lines = new ArrayList<String>();
		try
        {
			FileReader fr = new java.io.FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s;
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
                	System.out.println("NODE LINK:" + s);
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
