package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC7Test {
    /**
     * Test asserting that input where two consecutive points with k_pts inbetween them
     * have a distance between them less than "len"
     */
    @Test
    void falseTest() {
        double[] xs = {-1,0,0,0, 1};
        double[] ys = {-1,0,0,0, 1};
        double len = 3;
        int numpoints = xs.length;
        int K_pts = 3;
        assertFalse(LIC7.getCondition(xs, ys, numpoints, len, K_pts));
    }

    /**
     * Test asserting that input where two consecutive points with k_pts inbetween then 
     * have a distance between them greater than "len"
     */
    @Test
    void trueTest() {
        double[] xs = {1,0,0,3};
        double[] ys = {4,0,0,-2};
        double len = 4;
        int numpoints = xs.length;
        int K_pts = 2;
        assertTrue(LIC7.getCondition(xs, ys, numpoints, len, K_pts));
    }
    /**
     * A test with invalid input, the number of points has to be greter then or equal to 3
     */
    @Test
    void invalidInput() {
        double[] xs = {1,3};
        double[] ys = {4,-2};
        double len = 4;
        int numpoints = xs.length;
        int K_pts = 2;
        assertFalse(LIC7.getCondition(xs, ys, numpoints, len, K_pts));
    }

}