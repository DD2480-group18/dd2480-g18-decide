package group18.LIC;

public class LIC8 {

    public static boolean compute(double[] xList, double[] yList, double radius1, int A_PTS, int B_PTS, int numPoints) {

        for (int i = 0; i < numPoints - (A_PTS + B_PTS + 2); i++) {

            double x1 = xList[i], y1 = yList[i];
            double x2 = xList[i + A_PTS + 1], y2 = yList[i + A_PTS + 1];
            double x3 = xList[i + A_PTS + B_PTS + 2], y3 = yList[i + A_PTS + B_PTS + 2];
            double[] threePoints = new double[]{x1, y1, x2, y2, x3, y3};

            if (isOutside(threePoints, radius1)) {
                return true; // We found a set of points outside of circle with radius
            }
        }
        return false;
    }

    private static boolean isOutside(double[] points, double radius1) {
        // Odd index = x value; Even index = y value.
        double x1 = points[0], y1 = points[1];
        double x2 = points[2], y2 = points[3];
        double x3 = points[4], y3 = points[5];

        double distanceBetweenP1P2 = Calculator.computeDistance(x1, y1, x2, y2);
        double distanceBetweenP2P3 = Calculator.computeDistance(x2, y2, x3, y3);
        double distanceBetweenP1P3 = Calculator.computeDistance(x1, y1, x3, y3);

        if (distanceBetweenP1P2 > 2*radius1 || 
                distanceBetweenP2P3 > 2*radius1 ||
                distanceBetweenP1P3 > 2*radius1) {
            return true;
        }

        double[] center;
        double angleCircumference;
        double angleThirdPoint;

        if (distanceBetweenP1P2 > distanceBetweenP2P3 && distanceBetweenP1P2 > distanceBetweenP1P3) {
            // find center using point 1 and point 2
            center = Calculator.computeCenter(x1, y1, x2, y2, radius1);
            angleThirdPoint = Calculator.angleOn(x3, y3, x1, y1, x2, y2);
        } else if(distanceBetweenP2P3 > distanceBetweenP1P2 && distanceBetweenP2P3 > distanceBetweenP1P3) {
            // find center using point 2 and point 3
            center = Calculator.computeCenter(x2, y2, x3, y3, radius1);
            angleThirdPoint = Calculator.angleOn(x1, y1, x2, y2, x3, y3);
        } else {
            // find center using point 1 and point 3
            center = Calculator.computeCenter(x1, y1, x3, y3, radius1);
            // Compute angle at third point
            angleThirdPoint = Calculator.angleOn(x2, y2, x1, y1, x3, y3);
        }
        // Compute angle at circumference
        angleCircumference = Calculator.angleOnCircumference(x1, y1, x2, y2, center[0], center[1]);

        int comparator = Calculator.angleComparator(angleThirdPoint, angleCircumference);
        if (comparator == 1) {
            return true; // The set of three points does not fit inside circle
        } else {
            return false;
        }
    }
}