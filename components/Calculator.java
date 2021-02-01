public class Calculator {

    public static double computeDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    public static double[] computeCenter(double x1, double y1, double x2, double y2, double radius1) {
        double[] center = new double[2]; // index 0 = x; index 1 = y


        center[0] = (x1 + x2) / 2;
        center[1] = (y1 + y2) / 2;
        double distanceBetweenPoints = computeDistance(x1, y1, x2, y2);

        if ( distanceBetweenPoints == 2*radius1) {
            return center;
        }

        // Center point lies on a line perpendicular to (x1, y1)-(x2, y2)
        // Thus, one point on that line is x is (x1 + x2)/2 and center y (y1 + y2)/2.
        // To find the point we have to calculate how much we have to walk along the perpendicular line, dx and dy
        // Mirror distance is calculated with pythagoras theorem where the bases are distance/2 and mirror distance.
        // Radius is the hypotenuse.
        // radius ^ 2 = (distance/2) ^ 2 + mirror distance ^ 2. => mirror distance = sqrt(radius ^ 2 - (distance/2) ^ 2)
        double mirrorDistance = Math.sqrt(radius1 * radius1 - distanceBetweenPoints * distanceBetweenPoints / 4);
        // Change the sizes of vectors
        double dx = (x2 - x1) * mirrorDistance / distanceBetweenPoints;
        double dy = (y2 - y1) * mirrorDistance / distanceBetweenPoints;

        // modify the center according to calculations
        center[0] = center[0] - dy;
        center[1] = center[1] + dx;

        return center;
    }

    public static double angleOn(double x1, double y1, double x2, double y2, double px, double py) {
        double angleP1 = cosineRule(x1, y1, x2, y2, px, py);
        double angleP2 = cosineRule(x2, y2, x1, y1, px, py);
        // Sum of angles in triangle = 180
        double angleOutside = Math.PI - (angleP1 + angleP2);

        return angleOutside;
    }

    public static double angleOnCircumference(double x1, double y1, double x2, double y2, double centerX, double centerY) {
        // Calculate x and y coordinate for the new point
        double[] circPoint = computePointOnCircumference(x1, y1, centerX, centerY);

        // Compute angles
        double angleP1 = cosineRule(x1, y1, x2, y2, circPoint[0], circPoint[1]);
        double angleP2 = cosineRule(x2, y2, x1, y1, circPoint[0], circPoint[1]);
        // Angle sum of triangle = 180
        double anglePointAcross = Math.PI - (angleP1 + angleP2);

        return anglePointAcross;
    }

    public static double[] computePointOnCircumference(double x, double y, double centerX, double centerY) {
        double[] circPoint = new double[2];
        circPoint[0] = centerX - (x - centerX);
        circPoint[1] = centerY - (y - centerY);
        return circPoint;
    }

    /**
     * Compute angle on the point given with the first parameters two.
     * That is ax and ay.
     * Angle/Point A has sides a and b.
     * Angle/Point B has sides a and c.
     * Angle/Point C has sides b and c.
     */
    public static double cosineRule(double ax, double ay, double bx, double by, double cx, double cy) {
        double a = computeDistance(ax, ay, bx, by);
        double b = computeDistance(ax, ay, cx, cy);
        double c = computeDistance(bx, by, cx, cy);

        // Cosine rule: cos(A) = (b^2 + c^2 - a^2) / (2 * b * c)
        double bSquare = Math.pow(b, 2);
        double aSquare = Math.pow(a, 2);
        double cSquare = Math.pow(c, 2);
        double numerator = bSquare + aSquare - cSquare;
        double denominator = 2 * b * a;
        double quotient = numerator / denominator;
        // A = arc cosine( (b^2 + c^2 - a^2) / (2 * b * c) )
        return Math.acos(quotient);
    }

    public static int angleComparator(double angleThirdPoint, double angleCircPoint) {
        if (angleThirdPoint < angleCircPoint) {
            return 1; // Third point is outside
        } else if(angleThirdPoint > angleCircPoint) {
            return -1; // Third point is inside
        } else {
            return 0; // Third point is on circumference
        }
    }
}
