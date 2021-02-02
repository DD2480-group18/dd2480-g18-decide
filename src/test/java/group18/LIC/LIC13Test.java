package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC13Test {

    @Test
    void testValid() {
        int A_PTS = 2;
        int B_PTS = 2;
        double radius1 = 1;
        double radius2 = 4;
        int NUMPOINTS = 10;

        double[] xValid = new double[NUMPOINTS];
        double[] yValid = new double[NUMPOINTS];

        xValid[3] = 1;
        xValid[6] = 2;

        xValid[1] = 1;
        xValid[4] = 5;
        xValid[7] = 9;

        assertTrue( LIC13.compute(xValid, yValid, radius1, radius2, A_PTS, B_PTS, NUMPOINTS) );
    }

    @Test
    void testInvalid() {
        int A_PTS = 2;
        int B_PTS = 2;
        double radius = 1; // radius1=radius2=1
        int NUMPOINTS = 10;
        double[] xLinear = new double[NUMPOINTS];
        double[] yLinear = new double[NUMPOINTS];

        for (int i = 0; i < NUMPOINTS ; i++) {
            xLinear[i] = i;
        }

        assertFalse(LIC13.compute(xLinear, yLinear, radius, radius, A_PTS, B_PTS, NUMPOINTS));
    }

    @Test
    void testOrigo() {
        int A_PTS = 2;
        int B_PTS = 2;
        double radius = 1; // radius1=radius2=1
        int NUMPOINTS = 10;
        double[] xOrigo = new double[NUMPOINTS];
        double[] yOrigo = new double[NUMPOINTS];

        assertFalse(LIC13.compute(xOrigo, yOrigo, radius, radius, A_PTS, B_PTS, NUMPOINTS));
    }
}