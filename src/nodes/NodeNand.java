package nodes;

public class NodeNand extends Node {
	
	public int doCalc(){
		System.out.println("NAND:"+this.input.get(0) + " | "+ this.input.get(1));
		int out = 1;
		
		if(this.input.get(0) == 1 && this.input.get(1) == 1){
			out = 0;
		}
		
		return out;
	}

}
