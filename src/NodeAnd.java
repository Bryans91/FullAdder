
public class NodeAnd extends Node {

	public int doCalc(){
		int out = 0;
		
		if(this.input.get(0) == this.input.get(1)){
			out = 1;
		}
		
		return out;
	}
	
}
