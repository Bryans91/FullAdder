import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public abstract class Node extends Observable implements  Observer {
	
	private ArrayList<Observable> observables = new ArrayList<Observable>();
	private Observer observer;
	private int input1 ,input2;
	
	
	
	
	
	
	
	
	
	
	
	
	//Observable pattern fucntions
	public void addObservable(Node obs){
		this.observables.add(obs);
	}
	
	public void setObserver(Node obs){
		this.observer = obs;
	}
	
	
	//observable
	public void notifyObserver(Observable observable, int output){
		observable.update(observable, output);
	}
	
	
	//observer 
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
