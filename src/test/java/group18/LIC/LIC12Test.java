package group18.LIC;

import main.java.group18.LIC.LIC12;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LIC12Test {

    /**
     * Tests an input set that should evaluate to true
     */
    @Test
    void LIC12trueTest() {
        double[] xs = {-4, -3, -1, -1, 1, 1, 3, 3, 6, 6};
        double[] ys = {-1, 1, -1, 3, 1, 4, -2, 2, 1, 2};
        double LENGTH1 = 5;
        double LENGTH2 = 2;
        int NUM_POINTS = xs.length;
        int K_PTS = 1;
        assertTrue(LIC12.getCondition(xs, ys, NUM_POINTS, K_PTS, LENGTH1, LENGTH2));
    }

    /**
     * Tests an input set that should evaluate to false
     */
    @Test
    void LIC12falseTest1() {
        double[] xs = {-4, -3, -1, -1, 1, 1, 3, 3, 6};
        double[] ys = {-1, 1, -1, 3, 1, 4, -2, 2, 1};
        double LENGTH1 = 5;
        double LENGTH2 = 2;
        int NUM_POINTS = xs.length;
        int K_PTS = 1;
        assertFalse(LIC12.getCondition(xs, ys, NUM_POINTS, K_PTS, LENGTH1, LENGTH2));
    }
}
