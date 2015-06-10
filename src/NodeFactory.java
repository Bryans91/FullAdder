import java.util.ArrayList;

import nodes.*;

public class NodeFactory {
	
	ArrayList<Node> nodeList = new ArrayList<Node>();
	
	public void createNode(String nodeType){
		
		Node node = null;
		
		// Make a node depending on the nodeType
		if (nodeType.equals("AND")) {
			node = new NodeAnd();
		} else if (nodeType.equals("NAND")) {
			node = new NodeNand();
		} else if (nodeType.equals("NOR")) {
			node = new NodeNor();
		} else if (nodeType.equals("NOT")) {
			node = new NodeNot();
		} else if (nodeType.equals("OR")) {
			node = new NodeOr();
		} else if (nodeType.equals("XOR")) {
			node = new NodeXor();
		} else if (nodeType.equals("PROBE")) {
			node = new NodeXor(); // TODO
		}
		
		// If node is null, not a valid node.
		if (node != null) {
			System.out.println(
				"Nodetype \""+nodeType+"\" made on position: "+this.nodeList.size()
			);
			this.nodeList.add(node);
		}
	}
}