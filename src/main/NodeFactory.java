package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

import nodes.*;

public class NodeFactory {
	
	ArrayList<Node> nodeList = new ArrayList<Node>();
	private HashMap<String, Node> commands;
	
	public void createNode(String nodeType){
		
		Node node = null;
		
		
		commands = new HashMap<String, Node>();
		ServiceLoader<Node> loader = ServiceLoader.load(Node.class);
		for (Node command : loader) {
			commands.put(command.getClass().getSimpleName(), command);
		}
		
	
		if (commands.get(nodeType) != null) {		
				try {
					node = (Node) Class.forName("nodes."+nodeType).newInstance();
					node.setInputCount(2);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
			System.out.println("Node not found");
		    // No such key
		}
		
		
		
		
		// Make a node depending on the nodeType
		/*
		if (nodeType.equals("AND")) {
			node = new AND();
			node.setInputCount(2);
		} else if (nodeType.equals("NAND")) {
			node = new NAND();
			node.setInputCount(2);
		} else if (nodeType.equals("NOR")) {
			node = new NOR();
			node.setInputCount(2);
		} else if (nodeType.equals("NOT")) {
			node = new NOT();
			node.setInputCount(1);
		} else if (nodeType.equals("OR")) {
			node = new OR();
			node.setInputCount(2);
		} else if (nodeType.equals("XOR")) {
			node = new XOR();
			node.setInputCount(2);
		}
		*/
		// If node is null, not a valid node.
		if (node != null) {
			System.out.println(
				"Nodetype \""+nodeType+"\" made on position: "+this.nodeList.size()
			);
			this.nodeList.add(node);
		}
	}
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	
	public ArrayList<Node> getNodeList() {
		return this.nodeList;
	}
}