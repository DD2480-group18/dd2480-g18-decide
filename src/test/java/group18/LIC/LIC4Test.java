package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LIC4Test {
	@Test
	void passTest() {
		// Test with input that should be true
		double[] X = {1,-1};
		double[] Y = {1,-1};
		assertEquals(true, LIC4.lic4(2, 1, X, Y));
	}

	@Test
	void failTest() {
		// Test with input that should be false
		double[] X = {1,1};
		double[] Y = {1,1};
		assertEquals(false, LIC4.lic4(2, 1, X, Y));
	}

	@Test
	void edgeCases() {
		// Testing the quadrant priorities

		// quad 1
		double[] X = {0, 0, 1 };
		double[] Y = {0, 1, 0 };
		assertEquals(false, LIC4.lic4(3, 1, X, Y));

		// quad 2
		double[] X2 = {-1, -1};
		double[] Y2 = {0, 1};
		assertEquals(false, LIC4.lic4(2, 1, X2, Y2));

		// quad 3
		double[] X3 = {0, -1};
		double[] Y3 = {-1, -1};
		assertEquals(false, LIC4.lic4(2, 1, X3, Y3));

	}
}