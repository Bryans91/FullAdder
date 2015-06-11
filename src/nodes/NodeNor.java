package nodes;

public class NodeNor extends Node {

	public int doCalc(){
		System.out.println("NOR:"+this.input.get(0) + " | "+ this.input.get(1));
		int out = 0;
		
		if(this.input.get(0) == 0 && this.input.get(1) == 0){
			out = 1;
		}
		
		return out;
	}
	
}
