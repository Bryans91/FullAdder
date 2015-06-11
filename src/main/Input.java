package main;

import java.util.Observable;

import nodes.*;

public class Input extends Observable {

	public int input;
	
	public Input () {
	}
	
	public void setObserver(Node obs) {
		addObserver(obs);
	}
	
	public void update(Observable o, Object arg) {
		this.setChanged();
		notifyObservers(this.input);
	}
	
	public int getInput() {
		return this.input;
	}
	public void setInput(int input) {
		this.input = input;
	}
	
}
