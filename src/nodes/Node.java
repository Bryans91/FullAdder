package nodes;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public abstract class Node extends Observable implements  Observer {
	
	protected int inputCount = 0,output = 0;
	protected ArrayList<Integer> input = new ArrayList<Integer>();
	
	
	public int doCalc(){
		
		
		return output;
	}
	
	
	public void setObserver(Node obs){
		addObserver(obs);
	}
	
	//observer (when observed object is changed update is called)
	@Override
	public void update(Observable o, Object arg) {
		this.input.add((int) arg);
		
		if(this.inputCount == this.input.size()){
			this.output = this.doCalc();
			this.setChanged();
			notifyObservers(output);
		}	
	}
	
}
