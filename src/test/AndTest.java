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
public class AndTest {
	
	
	private Node and;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		this.and = new AND();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(1);
		this.and.setInput(input);
		
	}

	@Test
	public void test() {
		assertTrue("Check if result == 1", this.and.doCalc() == 1);
		
	}

}
