
public class NodeNot extends Node {
	
	
	public int doCalc(){
		int out = 0;
		
		if(this.input.get(0) == 0){
			out = 1;
		}
		
		return out;
	}

}
