package nodes;

import main.*;

import java.util.Observable;
import java.util.Observer;

public class Probe extends Node {

	private String probeType = null;
	private int output;
	private Circuit circuit;
	private String name;

	public Probe(String name){
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(this.name == "Cout"){
			this.circuit.carryOut = (int) arg;
		}
		System.out.println("\n\nTHE FINAL ANSWER OF " + this.name + " IS: " + arg);
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