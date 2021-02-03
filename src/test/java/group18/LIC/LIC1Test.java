package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LIC1Test {

    double radius1;
    double radius2;
    double radius10;

    int NUMPOINTS;

    // Linear
    double[] xLinear;
    double[] yLinear;

    // Three points at origo
    double[] xOrigo;
    double[] yOrigo;

    // Three points on unit circle
    double[] xUnitCircle;
    double[] yUnitCircle;

    // Helper function 
    private double[] generateLinearValues(int NUMPOINTS) {
        double[] datapoints = new double[NUMPOINTS];
        for (int i = 0; i < NUMPOINTS; i++) {
            datapoints[i] = i;
        }
        return datapoints;
    }

    // All three points are at the origo
    private double[] generateThreePointsOrigo(int NUMPOINTS) {
        double[] datapoints = new double[NUMPOINTS];
        for (int i = 0; i < 3; i++) {
            datapoints[i] = 0;
        }
        return datapoints;
    }

    // Helper function 
    private double[] generateXUnitCircle(int NUMPOINTS) {
        double[] xList = new double[NUMPOINTS];
        xList[0] = 1;
        xList[1] = 0;
        xList[2] = -1;
        return xList;
    }

    // Helper function 
    private double[] generateYUnitCircle(int NUMPOINTS) {
        double[] yList = new double[NUMPOINTS];
        yList[0] = 0;
        yList[1] = 1;
        yList[2] = 0;
        return yList;
    }

    // Set up the datapoints before running tests 
    public void setup() {

        NUMPOINTS = 10;
        // A single line on x axis with evenly spaced datapoints
        xLinear = generateLinearValues(10);
        yLinear = new double[10];

        // Three points at origo
        xOrigo = generateThreePointsOrigo(NUMPOINTS);
        yOrigo = generateThreePointsOrigo(NUMPOINTS);

        // Three points on unit circle
        xUnitCircle = generateXUnitCircle(NUMPOINTS);
        yUnitCircle = generateYUnitCircle(NUMPOINTS);


        radius1 = 1;
        radius2 = 2;
        radius10 = 10;
    }

    /**
     * This test works with all radias and three points on origo.
     */
    @Test
    void testSinglePointInOrigo() {
        setup();
        boolean result = LIC1.compute(xOrigo, yOrigo, radius1, 10);
        assertEquals(false, result);
    }

    /**
     * Unit circle with a right angle triangle with points (0, 0), (1, 0), (0, 1).
     */
    @Test
    void testRightAngledTriangleWithUnitCircle() {
        double[] xList = new double[10];
        double[] yList = new double[10];
        xList[0] = 0;
        yList[0] = 0;

        xList[1] = 1;
        yList[1] = 0;

        xList[2] = 0;
        yList[2] = 1;

        boolean result = LIC1.compute(xList, yList, radius1, NUMPOINTS);
        assertEquals(false, result);
    }

    /**
     * This test regards, 10 linear datapoints with radie 1.
     */
    @Test
    void testLinearDatapoints() {
        setup();
        LIC1.compute(xLinear, yLinear, radius1, NUMPOINTS);
    }

    /**
     * Test with larger right angle triangle and unit circle.
     */
    @Test
    void testValidInstance() {
        setup();
        double[] xList = new double[10];
        double[] yList = new double[10];
        xList[0] = 0;
        yList[0] = 0;

        xList[1] = 10;
        yList[1] = 0;

        xList[2] = 0;
        yList[2] = 10;

        boolean result = LIC1.compute(xList, yList, radius1, NUMPOINTS);
        assertEquals(true, result);
    }

    /**
     * This test regards checking for the condition where 
     * 0 <= radius1 meaning that the radius of the circle should be 
     * greater or equal to 0 and should return false otherwise. 
     */
    @Test
    void testInvalidInput() {
        int numPoints = 10;
        double[] xList = new double[numPoints];
        double[] yList = new double[numPoints];
        double radius1 = -1; 
        assertFalse(LIC1.compute(xList, yList, radius1, numPoints)); // This should return false 
    }
}