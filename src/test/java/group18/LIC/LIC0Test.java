package group18.LIC;

import group18.LIC.LIC0;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC0Test {
    /**
     * Test asserting that input where two consecutive points have a
     * distance between them less than "len"
     */
    @Test
    void falseTest() {
        double[] xs = {-1, 1};
        double[] ys = {-1, 1};
        double len = 3;
        assertFalse(LIC0.getCondition(xs, ys, len, 2));
    }

    /**
     * Test asserting that input where two consecutive points have a
     * distance between them greater than "len"
     */
    @Test
    void trueTest() {
        double[] xs = {1, 3};
        double[] ys = {4, -2};
        double len = 4;
        assertTrue(LIC0.getCondition(xs, ys, len, 2));
    }
}
