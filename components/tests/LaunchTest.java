import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LaunchTest {

    @Test
    void testLaunch1() {
        boolean[] FUV = new boolean[10];
        Arrays.fill(FUV, true);

        assertTrue(Launch.launch(FUV));
    }
    @Test
    void testLaunch2() {
        boolean[] FUV = new boolean[10];

        assertFalse(Launch.launch(FUV));
    }


}