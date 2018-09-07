package nodes;

public class NOT extends Node {
	
	protected int inputCount = 1;
	
	public int doCalc(){
		System.out.println("NOT:"+this.input.get(0));
		return 1 - this.input.get(0);
	}

}
