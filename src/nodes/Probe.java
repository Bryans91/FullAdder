package nodes;

import main.*;

import java.util.Observable;
import java.util.Observer;

public class Probe implements Observer {

	private String probeType = null;
	private int output;
	private Circuit circuit;
	
	@Override
	public void update(Observable o, Object arg) {
		this.output = (int) arg;
		this.circuit.carryOut = output;
		
		System.out.println(this.probeType+" output: "+(int)arg);
	}	
}