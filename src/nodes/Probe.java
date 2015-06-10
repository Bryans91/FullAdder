package nodes;

import java.util.Observable;
import java.util.Observer;

public class Probe implements Observer {

	String probeType = null;
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(this.probeType+" output: "+(int)arg);
	}	
}