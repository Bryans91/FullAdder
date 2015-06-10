
public class Main {

	public static void main(String[] args) {
		
		
		Circuit c1 = new Circuit("circuit.txt",0,1,1);
		
		
		Circuit c2 = new Circuit("circuit.txt",c1.carryOut,1,0);

	}

}
