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
public class XorTest {
	
	
	private Node xor;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		this.xor = new XOR();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(0);
		this.xor.setInput(input);
		
	}

	@Test
	public void test() {
		assertTrue("Check if result == 1", this.xor.doCalc() == 1);
		
	}

}
