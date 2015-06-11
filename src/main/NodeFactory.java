package main;

import java.util.ArrayList;

import nodes.*;

public class NodeFactory {
	
	ArrayList<Node> nodeList = new ArrayList<Node>();
	
	public void createNode(String nodeType){
		
		Node node = null;
		
		// Make a node depending on the nodeType
		if (nodeType.equals("AND")) {
			node = new NodeAnd();
			node.setInputCount(2);
		} else if (nodeType.equals("NAND")) {
			node = new NodeNand();
			node.setInputCount(2);
		} else if (nodeType.equals("NOR")) {
			node = new NodeNor();
			node.setInputCount(2);
		} else if (nodeType.equals("NOT")) {
			node = new NodeNot();
			node.setInputCount(1);
		} else if (nodeType.equals("OR")) {
			node = new NodeOr();
			node.setInputCount(2);
		} else if (nodeType.equals("XOR")) {
			node = new NodeXor();
			node.setInputCount(2);
		}
		
		// If node is null, not a valid node.
		if (node != null) {
			System.out.println(
				"Nodetype \""+nodeType+"\" made on position: "+this.nodeList.size()
			);
			this.nodeList.add(node);
		}
	}
	
	public ArrayList<Node> getNodeList() {
		return this.nodeList;
	}
}