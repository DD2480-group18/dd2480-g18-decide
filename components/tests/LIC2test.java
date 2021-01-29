
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC2Test {
    /**
     * Testing with incorrect input, the angle formed is 1.24 rad 
     * which is not less than pi-2.
     */
    @Test
    void falseTest() {
        double[] xs = {4,1,1};
        double[] ys = {2,1,3};
        LIC2 lic2 = new LIC2();
        assertFalse(lic2.getLic2(xs,ys,xs.length,3,2,3.1415926535, 2));
    }

    /**
     * Testing with correct input, the angle formed is 0.78 rad
     * which i less than pi-2.
     */
    @Test
    void trueTest() {
        double[] xs = {2,1,1};
        double[] ys = {2,1,3};
        LIC2 lic2 = new LIC2();
        assertTrue(lic2.getLic2(xs,ys,xs.length,2,1,3.1415926535, 2));
    }
}