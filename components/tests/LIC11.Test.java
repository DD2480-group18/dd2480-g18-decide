
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC11Test {
    /**
     * Testing with correct input, the point (4,2) followed by (1,1) 
     * with 2 dummy points inbetween
     * results in true since 1-4 = -3 < 0
     */
    @Test
    void trueTest() {
        double[] xs = {4,0,0,1,1};
        double[] ys = {2,0,0,1,3};
        LIC11 lic11 = new LIC11();
        assertFalse(lic11.getLic11(xs,ys,xs.length,2));
    }

    /**
     * Testing with incorrect input, since the x coordinates are increasing the 
     * condition will never be met and thus return false
     */
    @Test
    void falseTest() {
        double[] xs = {1,2,3,4,5};
        double[] ys = {2,0,0,1,3};
        LIC11 lic11 = new LIC11();
        assertTrue(lic11.getLic11(xs,ys,xs.length,2));
    }
}
