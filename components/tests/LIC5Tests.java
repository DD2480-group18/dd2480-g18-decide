
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC5Test {
    /**
     * Testing with correct input, the point (4,2) followed by (1,1)
     * results in true since 1-4 = -3 < 0
     */
    @Test
    void trueTest() {
        double[] xs = {4,1,1};
        double[] ys = {2,1,3};
        LIC5 lic5 = new LIC5();
        assertFalse(lic5.getLic5(xs,ys,xs.length));
    }

    /**
     * Testing with incorrect input, since the x coordinates are increasing the 
     * condition will never be met and thus return false
     */
    @Test
    void falseTest() {
        double[] xs = {1,2,3};
        double[] ys = {2,1,3};
        LIC5 lic5 = new LIC5();
        assertTrue(lic5.getLic5(xs,ys,xs.length));
    }
}