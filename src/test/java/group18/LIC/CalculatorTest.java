package group18.LIC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void computeDistance() {
        double x1 = -1, y1 = 0;
        double x2 = 1, y2 = 0;

        double result = Calculator.computeDistance(x1, y2, x2, y2);
        assertEquals(2, result);
    }

    @Test
    void computeCenter() {
        double x1 = -1, y1 = 0;
        double x2 = 1, y2 = 0;
        double radius = 1;

        double[] center = Calculator.computeCenter(x1, y1, x2, y2, radius);
        assertEquals(0, center[0]);
        assertEquals(0, center[1]);
    }

    @Test
    void angleOn() {
        double x1 = 0, y1 = 0;
        double x2 = 1, y2 = 0;
        double x3 = 0, y3 = 1;

        double result = Calculator.angleOn(x1, y1, x2, y2, x3, y3);
        assertEquals(45, result*180/Math.PI);
    }

    @Test
    void angleOnCircumference() {
        double x1 = -1, y1 = 0;
        double x2 = 0, y2 = 0;
        double centerX = 0, centerY = 0;

        double result = Calculator.angleOnCircumference(x1, y1, x2, y2, centerX, centerY);

        assertEquals(0, result);
    }

    @Test
    void computePointOnCircumference() {
    }

    @Test
    void cosineRule() {
        double ax = 0, ay = 0, bx = 1, by = 0, cx = 0, cy = 1;
        double result = Calculator.cosineRule(ax, ay, bx, by, cx, cy);

        assertEquals(90, Math.round(result*180/Math.PI));
    }

    @Test
    void angleComparator() {
        double anglePoint = 10;
        double angleCirc = 30;
        int result = Calculator.angleComparator(anglePoint, angleCirc);
        assertEquals(1, result);
    }
}