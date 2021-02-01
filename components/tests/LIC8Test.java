import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        radie = 1;
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
        radie = 1;
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
}