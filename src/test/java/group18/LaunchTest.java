package group18;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LaunchTest {

    /**
     * Tests that the Launch class returns
     * true when all FUV elements are true.
     */
    @Test
    void testLaunch1() {
        boolean[] FUV = new boolean[15];
        Arrays.fill(FUV, true);

        assertTrue(Launch.launch(FUV));
    }

    /**
     * Tests that the Launch class returns
     * true when all FUV elements are false.
     */
    @Test
    void testLaunch2() {
        boolean[] FUV = new boolean[15];

        assertFalse(Launch.launch(FUV));
    }


}