package nodes;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public abstract class Node extends Observable implements  Observer {
	
	protected int inputCount = 3,output = 0;
	protected ArrayList<Integer> input = new ArrayList<Integer>();
	protected boolean used = false;
	
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
		System.out.println("\nThis expects nr of inputs: " + inputCount);
		for (Integer in : this.input) {
			System.out.println("Incoming integer: " + in);
		}
		if(this.inputCount == this.input.size()){
			
			this.output = this.doCalc();
			System.out.println("Output = " + this.output);
			this.setChanged();
			notifyObservers(output);
		}	
	}
	
	public int getInputCount() {
		return this.inputCount;
	}
	public void setInputCount(int inputCount) {
		this.inputCount = inputCount;
	}
	public int getOutput() {
		return this.output;
	}
	public void setOutput(int output) {
		this.output = output;
	}
	public ArrayList<Integer> getInput() {
		return input;
	}
	public void setInput(ArrayList<Integer> input) {
		this.input = input;
	}
	public boolean getUsed() {
		return this.used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	
}
