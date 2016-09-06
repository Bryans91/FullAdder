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
public class OrTest {
	
	
	private Node or;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		this.or = new OR();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(1);
		this.or.setInput(input);
		
	}

	@Test
	public void test() {
		assertTrue("Check if result == 1", this.or.doCalc() == 1);
		
	}

}
