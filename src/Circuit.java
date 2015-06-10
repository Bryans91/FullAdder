import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Circuit {
	
	private ArrayList<String> lines;
	private int carryIn, a, b;
	public int carryOut;
	
	public Circuit(String fileName, int carryIn, int a ,int b){
		this.a = a;
		this.b = b;
		this.carryIn = carryIn;
		readFile(fileName);
		
		
		for(String l : lines){
			System.out.println(l);
		}
		

	}
	
	
	public boolean readFile(String fileName){
			lines = new ArrayList<>();
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
	        catch (FileNotFoundException e)             { System.out.println("File: " + fileName + " does not exist. Exiting program."); System.exit(1); }
	        catch (IOException e)                       { System.out.println("Failed to read file: " + fileName + ". Exiting program."); System.exit(1); }
		return true;
	}
	
	
	
	

}
