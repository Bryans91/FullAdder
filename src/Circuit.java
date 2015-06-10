import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Circuit {
	
	private NodeFactory nodeFactory = new NodeFactory();
	private ArrayList<String> lines;
	private int carryIn, a, b;
	public int carryOut,sOut;
	
	
	public Circuit(String fileName, int carryIn){
		this.carryIn = carryIn;
		readFile(fileName);
		createCircuit();
	}
	
	
	
	
	
	private void createCircuit() {;
		
		// nodeType (String) can be: AND, NAND, NOR, NOT, OR, XOR
		this.nodeFactory.createNode("AND");
		
	}





	public boolean readFile(String fileName){
			lines = new ArrayList<String>();
	        try
	        {
	        	FileReader fr = new java.io.FileReader(fileName);
	            BufferedReader br = new BufferedReader(fr);
	            String s;
	            while ((s = br.readLine()) != null)
	            {
	                s = s.replaceAll("\\t", "").replaceAll("\\n", "").replaceAll(" ", "");
	                this.lines.add(s);
	            }

	            fr.close();
	        }
	        catch (FileNotFoundException e){ 
	        	System.out.println("File: " + fileName + " does not exist. Exiting program."); System.exit(1); 
	        	}
	        catch (IOException e){ 
	        	System.out.println("Failed to read file: " + fileName + ". Exiting program."); System.exit(1); 
	        	}
		return true;
	}
	
	
	
	

}
