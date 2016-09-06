package nodes;

public class AND extends Node {
	
	protected int inputCount = 2;
	
	public int doCalc(){
		System.out.println("AND:"+this.input.get(0) + " | "+ this.input.get(1));
		int out = 0;
		if(this.input.get(0) == this.input.get(1)){
			out = 1;
		}
		
		return out;
	}
	
}
