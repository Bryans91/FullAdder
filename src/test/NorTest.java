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
public class NorTest {
	
	
	private Node nor;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		this.nor = new NOR();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(0);
		this.nor.setInput(input);
		
	}

	@Test
	public void test() {
		assertTrue("Check if result == 1", this.nor.doCalc() == 1);
		
	}

}
