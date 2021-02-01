import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC13Test {

    @Test
    void testValid() {
        int A_PTS = 2;
        int B_PTS = 2;
        double  radius = 1;
        int NUMPOINTS = 10;

        double[] xValid = new double[NUMPOINTS];
        double[] yValid = new double[NUMPOINTS];

        xValid[3] = 1;
        xValid[6] = 2;

        xValid[1] = 1;
        xValid[4] = 5;
        xValid[7] = 9;

        assertTrue( LIC13.compute(xValid, yValid, radius, A_PTS, B_PTS, NUMPOINTS) );
    }

    @Test
    void testInvalid() {
        int A_PTS = 2;
        int B_PTS = 2;
        double  radius = 1;
        int NUMPOINTS = 10;
        double[] xLinear = new double[NUMPOINTS];
        double[] yLinear = new double[NUMPOINTS];

        for (int i = 0; i < NUMPOINTS ; i++) {
            xLinear[i] = i;
        }

        assertFalse(LIC13.compute(xLinear, yLinear, radius, A_PTS, B_PTS, NUMPOINTS));
    }

    @Test
    void testOrigo() {
        int A_PTS = 2;
        int B_PTS = 2;
        double  radius = 1;
        int NUMPOINTS = 10;
        double[] xOrigo = new double[NUMPOINTS];
        double[] yOrigo = new double[NUMPOINTS];

//        LIC13 lic = new LIC13(xOrigo, yOrigo, radius, A_PTS, B_PTS);
        assertFalse(LIC13.compute(xOrigo, yOrigo, radius, A_PTS, B_PTS, NUMPOINTS));
    }
}