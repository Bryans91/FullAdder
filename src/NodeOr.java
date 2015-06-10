
public class NodeOr extends Node {
	
	public int doCalc(){
		int out = 0;
		
		if(this.input.get(0) == 1 || this.input.get(1) == 1){
			out = 1;
		}
		
		return out;
	}

}
