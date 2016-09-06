package nodes;

public class NOT extends Node {
	
	
	public int doCalc(){
		System.out.println("NOT:"+this.input.get(0));
		int out = 0;
		
		if(this.input.get(0) == 0){
			out = 1;
		}
		
		return out;
	}

}
