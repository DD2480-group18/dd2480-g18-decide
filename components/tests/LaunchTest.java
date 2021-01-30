import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaunchTest {

    @Test
    void testLaunch1() {
        boolean[] FUV = new boolean[10];
        for (int i = 0; i < FUV.length; i++) {
            FUV[i] = true;
        }

        assertTrue(Launch.launch(FUV));
    }
    @Test
    void testLaunch2() {
        boolean[] FUV = new boolean[10];

        assertFalse(Launch.launch(FUV));
    }


}