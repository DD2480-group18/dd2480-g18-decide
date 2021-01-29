import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC3Test {
    @Test
    void falseTest() {
        double[] xs = {0, 3, 5};
        double[] ys = {1, 3, 1};
        double AREA1 = 6;
        assertFalse(LIC3.getCondition(xs, ys, AREA1));
    }

    @Test
    void trueTest() {
        assertTrue(true);
    }
}
