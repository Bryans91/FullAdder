
public class NodeNand extends Node {
	
	public int doCalc(){
		int out = 1;
		
		if(this.input.get(0) == 1 && this.input.get(1) == 1){
			out = 0;
		}
		
		return out;
	}

}
