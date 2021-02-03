package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LIC8Test {
    // Parameters
    double radie;
    int A_PTS;
    int B_PTS;
    int NUMPOINTS;

    double[] xFalse;
    double[] yFalse;

    double[] xTrue;
    double[] yTrue;

    double[] xOrigo;
    double[] yOrigo;

    LIC8 lic8;

    /**
     * This test contains datapoints that lies on the x-axis.
     * The distance between the points is 1. This means that if
     * we have 2 consecutive intervening points
     * the distance between the first and third point should be 4.
     * This means we cannot place a circle with radie 1 that encapsulates
     * a set of three points.
     */
    @Test
    void testTrueInstance() {
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // 0 3 6
        A_PTS = 2;
        B_PTS = 3;
        radie = 0;
        NUMPOINTS = 10;
        xTrue = new double[NUMPOINTS];
        yTrue = new double[NUMPOINTS];
        for (int i = 0; i < NUMPOINTS ; i++) {
            xTrue[i] = i;
        }

        boolean result = LIC8.compute(xTrue, yTrue, radie, A_PTS, B_PTS, NUMPOINTS);

        assertTrue(result);
    }

    /**
     * All points should be on origo. That is the coordinate (0, 0).
     * This means we should be able to encapsulate a set of three points
     * with a circle of radie 1. The method compute() should return false.
     * That is we have not found a set of points that we cannot encapsulate
     * with a circle.
     */
    @Test
    void testOrigo() {

        NUMPOINTS = 10;
        A_PTS = 2;
        B_PTS = 2;
        radie = 3;
        xOrigo = new double[NUMPOINTS];
        yOrigo = new double[NUMPOINTS];
        
        boolean result = LIC8.compute(xOrigo, yOrigo, radie, A_PTS, B_PTS, NUMPOINTS);

        assertFalse(result);
    }

    /**
     * This test regards sets of datapoints that lies on the x-axis with distance 1 from each other.
     * This means we have a largest distance of 4. We should be able to encapsulate
     * the three set of points with a circle of radie 3. This means we cannot find a set of datapoints
     * that lies outside of the circle.
     */
    @Test
    void testFalseInstance() {
        NUMPOINTS = 10;
        A_PTS = 2;
        B_PTS = 2;
        radie = 3;

        xFalse = new double[NUMPOINTS];
        yFalse = new double[NUMPOINTS];
        for (int i = 0; i < xFalse.length ; i++) {
            xFalse[i] = i;
        }


        boolean result = LIC8.compute(xFalse, yFalse, radie, A_PTS, B_PTS, NUMPOINTS);

        assertFalse(result);
    }

    /**
     * This test is about the condition where the radius is invalid. 
     */
    @Test
    void testInvalidRadius() {
        double[] xList = new double[NUMPOINTS];
        double[] yList = new double[NUMPOINTS];
        double radius1 = -1; // Invalid 
        int A_PTS = 1;
        int B_PTS = 1;

        assertFalse(LIC8.compute(xList, yList, radius1, A_PTS, B_PTS, NUMPOINTS));
    }

    /**
     * This test is about the condition where the number of A_PTS is less than 1. 
     */
    @Test 
    void testInvalidA_PTS() {
        double[] xList = new double[NUMPOINTS];
        double[] yList = new double[NUMPOINTS];
        double radius1 = 1; 
        int A_PTS = 0; // Invalid
        int B_PTS = 1;

        assertFalse(LIC8.compute(xList, yList, radius1, A_PTS, B_PTS, NUMPOINTS));
    }


    /**
     * This test is about the condition where number of B_PTS is less than 1. 
     */
    @Test 
    void testInvalidB_PTS() {
        double[] xList = new double[NUMPOINTS];
        double[] yList = new double[NUMPOINTS];
        double radius1 = 1; 
        int A_PTS = 1; 
        int B_PTS = 0; // Invalid

        assertFalse(LIC8.compute(xList, yList, radius1, A_PTS, B_PTS, NUMPOINTS));
    }

    /**
     * This test is about the condition where number of points is less than 5. 
     */
    @Test 
    void testInvalidNumPoints() {
        int numPoints = 1; 
        double[] xList = new double[numPoints];
        double[] yList = new double[numPoints];
        double radius1 = 1; 
        int A_PTS = 1; 
        int B_PTS = 0; 

        assertFalse(LIC8.compute(xList, yList, radius1, A_PTS, B_PTS, numPoints));
    }
}