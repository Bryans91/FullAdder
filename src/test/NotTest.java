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
public class NotTest {
	
	
	private Node not;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		this.not = new NOT();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(0);
		this.not.setInput(input);
		
	}

	@Test
	public void test() {
		assertTrue("Check if result == 1", this.not.doCalc() == 1);
		
	}

}
