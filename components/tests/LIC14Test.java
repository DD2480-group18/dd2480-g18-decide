// package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC14Test {
	/**
	 * Test with input known to give a false result, area of triangle is 5
	 */
	@Test
	void falseTest() {
		double[] xs = {0, 0, 3, 0, 5};
		double[] ys = {1, 0, 3, 0, 1};
        double AREA1 = 6;
        double AREA2 = 3;
		assertFalse(LIC14.getCondition(xs, ys, AREA1, AREA2, 1, 1, xs.length));
	}

	/**
	 * Test with input known to give a true result, area of triangle is 5
	 */
	@Test
	void trueTest() {
		double[] xs = {0, 0, 0, 3, 0, 0, 5};
		double[] ys = {1, 0, 0, 3, 0, 0, 1};
        double AREA1 = 3;
        double AREA2 = 6;
		assertTrue(LIC14.getCondition(xs, ys, AREA1, AREA2, 2, 2, xs.length));
	}

	/**
	 * Test with input known to give a true result, but two points are the same (i.e. the distance between them is 0
	 */
	@Test
	void samePointTest() {
		double[] xs = {0, 0, 0, 0, 3, 0, 5};
		double[] ys = {1, 0, 1, 0, 3, 0, 1};
        double AREA1 = 3;
        double AREA2 = 6;
		assertTrue(LIC14.getCondition(xs, ys, AREA1, AREA2, 1, 1, xs.length));
	}

    /**
     * Testing invalid data where the number of points are to few
     */
    @Test
    void invalidDataTest(){
		double[] xs = {0, 0, 0, 0};
		double[] ys = {0, 0, 0, 0};
        double AREA1 = 1;
        double AREA2 = 0;
		assertFalse(LIC14.getCondition(xs, ys, AREA1, AREA2, 1,  1, xs.length));
	}
}
