import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LIC1Test {

    LIC1 lic1 = null;
    LIC1 lic2 = null;
    LIC1 lic10 = null;
    LIC1 licTester = null;

    double radius1;
    double radius2;
    double radius10;

    public double[] generateLinearValues(int numberOfPoints) {
        double[] datapoints = new double[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            datapoints[i] = i;
        }
        return datapoints;
    }

    // All three points are at the origo
    public double[] generateThreePointsOrigo() {
        double[] datapoints = new double[3];
        for (int i = 0; i < 3; i++) {
            datapoints[i] = 0;
        }
        return datapoints;
    }

    private double[] generateXUnitCircle() {
        double[] xList = new double[10];
        xList[0] = 1;
        xList[1] = 0;
        xList[2] = -1;
        return xList;
    }

    private double[] generateYUnitCircle() {
        double[] yList = new double[10];
        yList[0] = 0;
        yList[1] = 1;
        yList[2] = 0;
        return yList;
    }

    @Before
    public void setup() {
        // A single line on x axis with evenly spaced datapoints
        double[] xLinear = generateLinearValues(10);
        double[] yLinear = new double[10];

        // Three points at origo
        double[] xOrigo = generateThreePointsOrigo();
        double[] yOrigo = generateThreePointsOrigo();

        // Three points on unit circle
        double[] xUnitCircle = generateXUnitCircle();
        double[] yUnitCircle = generateYUnitCircle();


        radius1 = 1;
        radius2 = 2;
        radius10 = 10;

        lic1 = new LIC1(xOrigo, yOrigo, radius1); // Test origo
        lic2 = new LIC1(xUnitCircle, yUnitCircle, radius1); // Test unit circle
        lic10 = new LIC1(xLinear, yLinear, radius1); // Test linear
        licTester = new LIC1();
    }

    /**
     * This test works with all radias and three points on origo.
     */
    @Test
    void testSinglePointInOrigo() {
        setup();
        assertEquals(false, lic1.compute());
    }

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

        LIC1 lic = new LIC1(xList, yList, 5);
        assertEquals(false, lic.compute());
    }

    /**
     * This test regards, 10 linear datapoints with radie 1.
     */
    @Test
    void testLinearDatapoints() {
        setup();
        assertEquals(false, lic10.compute());
    }

    @Test
    void testFindCircleCenter() {
        setup();
        double x1 = 0, y1 = 2;
        double x2 = 0, y2 = 0;
        assertEquals(0, licTester.computeCenterX(x1, y1, x2, y2, 1));
        assertEquals(1, licTester.computeCenterY(x1, y1, x2, y2, 1));
    }

    @Test
    void testFindCircleCenterInOrigo() {
        setup();
        double x1 = 0, y1 = 2;
        double x2 = 0, y2 = 0;
        assertEquals(0, licTester.computeCenterX(x1, y1, x2, y2, 1));
        assertEquals(1, licTester.computeCenterY(x1, y1, x2, y2, 1));
    }

    @Test
    void testPointOnCircumference() {
        setup();
        double x1 = 1, y1 = 0;
        double x2 = 0, y2 = 1;
        double centerX = licTester.computeCenterX(x1, y1, x2, y2, 1);
        double centerY = licTester.computeCenterY(x1, y1, x2, y2, 1);
        assertEquals( -1, licTester.computePointOnCircumferenceX(x1, y1, centerX, centerY));
        assertEquals( 0, Math.round(licTester.computePointOnCircumferenceY(x1, y1, centerX, centerY)));
    }

    @Test
    void testCosine() {
        LIC1 lic = new LIC1();

        double x1 = 1, y1 = 1;
        double x2 = 3, y2 = 1;
        double x3 = 2, y3 = 2;


        double angleP1 = lic.computeAngleWithCosineRule(x1, y1, x2, y2, x3, y3);
        assertEquals(45, (int) Math.round(angleP1*180/Math.PI));
        double angleP2 = lic.computeAngleWithCosineRule(x2, y2, x3, y3, x1, y1);
        assertEquals(45, (int) Math.round(angleP2*180/Math.PI));
        double angleP3 = lic.computeAngleWithCosineRule(x3, y3, x1, y1, x2, y2);
        assertEquals(90, (int) Math.round(angleP3*180/Math.PI));
    }
}