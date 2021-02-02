package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC6Test {
    /**
     * Testing with incorrect input, (4,2) and (3,1) form a line
     * that can be described with the equation -x + y - 2 = 0
     * it passes through (0,-2) and (2,0) which are at a distance
     * of exactly 2 from the origin points (0,0) - the only
     * intermediary points in this input. Since the line segment
     * that crosses these two points will be closer than the points
     * themselves, the shortest distance is guaranteed to be <= 2.
     */
    @Test
    void falseTest() {
        double[] X = {4,0,0,3};
        double[] Y = {2,0,0,1};
        int NUMPOINTS = 4;
        int N_PTS = 3;
        double DIST = 2;
        assertFalse(LIC6.getLic6(X, Y, NUMPOINTS, N_PTS, DIST));
    }

    /**
     * Testing with correct input, (4,2) and (-3,-12) form a line
     * that can be described with the equation -2x + y + 6 = 0
     * it passes through (0,-6) and (1,-4)
     * yielding shortest distance~=2.68 for any of the origin points (0,0),
     * meaning the call should return true for the first point in the origin.
     */
    @Test
    void trueTest() {
        double[] X = {4,0,0,0,1,-3};
        double[] Y = {2,0,0,0,1,-12};
        int NUMPOINTS = 6;
        int N_PTS = 6;
        double DIST = 2;
        assertTrue(LIC6.getLic6(X, Y, NUMPOINTS, N_PTS, DIST));
    }


    /**
     * Testing with invalid input. NUMPOINTS must be at least 3,
     * so this test should return false per the asssignment.
     */
    @Test
    void invalidTest() {
        double[] X = {4,0,0,0,1,-3};
        double[] Y = {2,0,0,0,1,-12};
        int NUMPOINTS = 2;
        int N_PTS = 6;
        double DIST = 2;
        assertFalse(LIC6.getLic6(X, Y, NUMPOINTS, N_PTS, DIST));
    }

    /**
     * Testing with correct input, examining the case where x1=x0,
     * normally risking division by zero. The first intermediate
     * point lies at (1,2) where the closest point on the line is
     * (0,2), at a distance of 1. Thus it is farther away than 0.1.
     */
    @Test
    void verticalLineTrueTest() {
        double[] X = {0,1,0,0};
        double[] Y = {-3,2,0,3};
        int NUMPOINTS = 4;
        int N_PTS = 4;
        double DIST = 0.1;
        assertTrue(LIC6.getLic6(X, Y, NUMPOINTS, N_PTS, DIST));
    }

    /**
     * Testing with correct input, examining the case where x1=x0,
     * normally risking division by zero. Both of the intermediate
     * points are on the line and should thus not be farther away
     * than DIST.
     */
    @Test
    void verticalLineFalseTest() {
        double[] X = {0,0,0,0};
        double[] Y = {-3,2,-1,3};
        int NUMPOINTS = 4;
        int N_PTS = 4;
        double DIST = 0.00001;
        assertFalse(LIC6.getLic6(X, Y, NUMPOINTS, N_PTS, DIST));
    }

}
