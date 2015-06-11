package nodes;

import main.*;

import java.util.Observable;
import java.util.Observer;

public class Probe extends Node {

	private String probeType = null;
	private int output;
	private Circuit circuit;

	@Override
	public void update(Observable o, Object arg) {
		this.input.add((int) arg);
		System.out.println("This node has inputcount: " + inputCount);
		for (Integer in : this.input) {
			System.out.println("Incoming integer: " + in);
		}
		if(this.inputCount == this.input.size()){
			this.output = (int) arg;
			this.circuit.carryOut = output;
			System.out.println(this.probeType+" output: "+(int)arg);
		}	
	}
	
	public int getOutput() {
		return this.output;
	}
	public void setOutput(int output) {
		this.output = output;
	}

	public String getProbeType() {
		return probeType;
	}

	public void setProbeType(String probeType) {
		this.probeType = probeType;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
	
	
}