public class LIC8 {
    private double[] xList;
    private double[] yList;
    private int listLength;
    private double radius1;
    private int A_PTS;
    private int B_PTS;

    public LIC8() {
        // Empty constructor for testing purposes
    }

    public LIC8(double[] xList, double[] yList, double radius1, int A_PTS, int B_PTS) {
        this.xList = xList;
        this.yList = yList;
        this.listLength = xList.length;

        this.A_PTS = A_PTS;
        this.B_PTS = B_PTS;
        this.radius1 = radius1;
    }

    public boolean compute() {

        if (listLength < 5) {
            throw new IllegalArgumentException("NUMPOINTS was invalid. It should be greater than 5.");
        } else if( A_PTS < 1 || B_PTS < 1) {
            throw new IllegalArgumentException("Either A_PTS or B_PTS is invalid. They should be greater or equal to 1");
        } else if(A_PTS + B_PTS > listLength - 3) {
            throw new IllegalArgumentException("Summation of A_PTS and B_PTS exceeds the number of datapoints.");
        }

        boolean isOutsideTheCircle = false;

        for (int i = 0; i < listLength - (A_PTS + B_PTS + 2); i++) {

            double x1 = xList[i], y1 = yList[i];
            double x2 = xList[i + A_PTS + 1], y2 = yList[i + A_PTS + 1];
            double x3 = xList[i + A_PTS + B_PTS + 2], y3 = yList[i + A_PTS + B_PTS + 2];

            double distanceBetweenP1P2 = computeDistance(x1, y1, x2, y2); // 1 - 2
            double distanceBetweenP2P3 = computeDistance(x2, y2, x3, y3); // 1 - 2
            double distanceBetweenP1P3 = computeDistance(x1, y1, x3, y3); // 1 - 2

            if (distanceBetweenP1P2 > 2*radius1 || distanceBetweenP2P3 > 2*radius1 || distanceBetweenP1P3 > 2*radius1) {
                // We know that the diameter can't fit the longest distance so we break the searching.
                // There is one set which doesn't fit the circle
                isOutsideTheCircle = true;
                break;
            }

            double centerX;
            double centerY;
            double angleCircumference;
            double angleCompare;

            if (distanceBetweenP1P2 > distanceBetweenP2P3 && distanceBetweenP1P2 > distanceBetweenP1P3) {
                // find center using point 1 and point 2
                centerX = computeCenterXorY(x1, y1, x2, y2, radius1, 'X');
                centerY = computeCenterXorY(x1, y1, x2, y2, radius1, 'Y');
            } else if(distanceBetweenP2P3 > distanceBetweenP1P2 && distanceBetweenP2P3 > distanceBetweenP1P3) {
                // find center using point 2 and point 3
                centerX = computeCenterXorY(x2, y2, x3, y3, radius1, 'X');
                centerY = computeCenterXorY(x2, y2, x3, y3, radius1, 'Y');
            } else {
                // find center using point 1 and point 3
                centerX = computeCenterXorY(x1, y1, x3, y3, radius1, 'X');
                centerY = computeCenterXorY(x1, y1, x3, y3, radius1, 'Y');
            }
            // Compute angle at circumference
            angleCircumference = angleOnCircumference(x1, y1, x2, y2, centerX, centerY, radius1);

            // Compute angle at third point
            angleCompare = getAngleOn(x1, y1, x2, y2, x3, y3);

            int comparator = angleComparator(angleCircumference, angleCompare);
            if (comparator == 1) {
                System.out.println("Outside");
                isOutsideTheCircle = true;
                break;
            }
//            isOutsideTheCircle = isOutsideTheCircle || comparator == 1 ? true : false;
        }

        return isOutsideTheCircle;
    }

    private double computeDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    private double computeCenterXorY(double x1, double y1, double x2, double y2, double radius1, char coordinate) {
        double centerX = (x1 + x2) / 2;
        double centerY = (y1 + y2) / 2;
        double distanceBetweenPoints = computeDistance(x1, y1, x2, y2);
        if ( distanceBetweenPoints == radius1) {
            // The diameter is the distance between the two points
            if (coordinate == 'X') {
                return centerX;
            } else if (coordinate == 'Y') {
                return centerY;
            } else {
                throw new Error("X or Y coordinate was not given");
            }
        }

        double mirrorDistance = Math.sqrt(radius1 * radius1 - distanceBetweenPoints * distanceBetweenPoints / 4);
        double dx = (x2 - x1) * mirrorDistance / distanceBetweenPoints;
        double dy = (y2 - y1) * mirrorDistance / distanceBetweenPoints;

        // modify the center
        centerX = centerX - dy;
        centerY = centerY + dx;

        if (coordinate == 'X') {
            return centerX;
        } else if (coordinate == 'Y') {
            return centerY;
        } else {
            throw new Error("X or Y coordinate was not given");
        }
    }

    public double computeCenterX(double x1, double y1, double x2, double y2, double radius1) {
        return computeCenterXorY(x1, y1, x2, y2, radius1, 'X');
    }
    public double computeCenterY(double x1, double y1, double x2, double y2, double radius1) {
        return computeCenterXorY(x1, y1, x2, y2, radius1, 'Y');
    }

    private double getAngleOn(double x1, double y1, double x2, double y2, double px, double py) {
        double angleP1 = computeAngleAt(x1, y1, x2, y2, px, py);
        double angleP2 = computeAngleAt(x2, y2, x1, y1, px, py);
        // Sum of angles in triangle = 180
        double angleOutside = 180 - (angleP1 + angleP2);

        return angleOutside;
    }

    private double angleOnCircumference(double x1, double y1, double x2, double y2, double centerX, double centerY, double radius1) {
        // Calculate x and y coordinate for the new point
        double pointX = computePointOnCircumference(x1, y1, centerX, centerY, 'X');
        double pointY = computePointOnCircumference(x1, y1, centerX, centerY, 'Y');

        // Compute angles
        double angleP1 = computeAngleAt(x1, y1, x2, y2, pointX, pointY);
        double angleP2 = computeAngleAt(x2, y2, x1, y1, pointX, pointY);
        // Angle sum of triangle = 180
        double anglePointAcross = 180 - (angleP1 + angleP2);

        return anglePointAcross;
    }

    private double computePointOnCircumference(double x, double y, double centerX, double centerY, char coordinate) {
        double pointX = centerX - (x - centerX);
        double pointY = centerY - (y - centerY);
        if (coordinate == 'X') {
            return pointX;
        } else if(coordinate == 'Y') {
            return pointY;
        } else {
            throw new IllegalArgumentException("Coordinate was wrongfully given.");
        }
    }

    public double computePointOnCircumferenceX(double x, double y, double centerX, double centerY) {
        return computePointOnCircumference(x, y, centerX, centerY, 'X');
    }
    public double computePointOnCircumferenceY(double x, double y, double centerX, double centerY) {
        return computePointOnCircumference(x, y, centerX, centerY, 'Y');
    }
    /**
     * Angle/Point A has sides a and b.
     * Angle/Point B has sides a and c.
     * Angle/Point C has sides b and c.
     */
    private double computeAngleAt(double ax, double ay, double bx, double by, double cx, double cy) {
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

    public double computeAngleWithCosineRule(double ax, double ay, double bx, double by, double cx, double cy) {
        return computeAngleAt(ax, ay, bx, by, cx, cy);
    }

    private int angleComparator(double angle1, double angle2) {
        if (angle1 > angle2) {
            return 1; // Angle 1 is greater
        } else if(angle1 < angle2) {
            return -1; // Angle 2 is greater
        } else {
            return 0; // both of the are equal meaning that the two points lie on the circumference
        }
    }
}
