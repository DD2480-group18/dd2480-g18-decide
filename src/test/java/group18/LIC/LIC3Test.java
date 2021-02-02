package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC3Test {
    /**
     * Test with input known to give a false result
     */
    @Test
    void falseTest() {
        double[] xs = {0, 3, 5};
        double[] ys = {1, 3, 1};
        double AREA1 = 6;
        assertFalse(LIC3.getCondition(xs, ys, AREA1, xs.length));
    }

    /**
     * Test with input known to give a true result
     */
    @Test
    void trueTest() {
        double[] xs = {0, 3, 5};
        double[] ys = {1, 3, 1};
        double AREA1 = 3;
        assertTrue(LIC3.getCondition(xs, ys, AREA1, xs.length));
    }

    /**
     * Test with input known to give a true result, but two points are the same (i.e. the distance between them is 0
     */
    @Test
    void samePointTest() {
        double[] xs = {0, 0, 3, 5};
        double[] ys = {1, 1, 3, 1};
        double AREA1 = 3;
        assertTrue(LIC3.getCondition(xs, ys, AREA1, xs.length));
    }

    @Test
    void invalidDataTest(){
        double[] xs = {0, 0};
        double[] ys = {0, 0};
        double AREA1 = 1;
        assertFalse(LIC3.getCondition(xs, ys, AREA1, xs.length));
    }
}
