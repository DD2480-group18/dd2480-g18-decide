package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC4Test {
	/**
	 * Test with input that should be true
	 */
	@Test
	void passTest() {
		double[] X = {1,-1};
		double[] Y = {1,-1};
		assertEquals(true, LIC4.lic4(2, 1, X, Y, 2));
	}

	/**
	 * Test with input that should be false
	 */
	@Test
	void failTest() {
		double[] X = {1,1};
		double[] Y = {1,1};
		assertEquals(false, LIC4.lic4(2, 1, X, Y, 2));
	}

	/**
	 * Testing the quadrant priorities, points along the axis should prioritise the lower numbered one
	 */
	@Test
	void edgeCases() {
		// Testing the quadrant priorities

		// quad 1
		double[] X = {0, 0, 1 };
		double[] Y = {0, 1, 0 };
		assertEquals(false, LIC4.lic4(3, 1, X, Y, 3));

		// quad 2
		double[] X2 = {-1, -1};
		double[] Y2 = {0, 1};
		assertEquals(false, LIC4.lic4(2, 1, X2, Y2, 2));

		// quad 3
		double[] X3 = {0, -1};
		double[] Y3 = {-1, -1};
		assertEquals(false, LIC4.lic4(2, 1, X3, Y3, 2));

	}

	/**
	 * Test with invalid input
	 */
	@Test
	void invalidTest(){
		double[] X = {1,-1};
		double[] Y = {1,-1};
		assertFalse(LIC4.lic4(3, 1, X, Y, 2));
	}
}