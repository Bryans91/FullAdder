/**
 * 
 */
package test;
import java.util.ArrayList;

import nodes.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author bryan
 *
 */
public class NandTest {
	
	
	private Node nand;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		this.nand = new NAND();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(1);
		this.nand.setInput(input);
		
	}

	@Test
	public void test() {
		assertTrue("Check if result == 0", this.nand.doCalc() == 0);
		
	}

}
