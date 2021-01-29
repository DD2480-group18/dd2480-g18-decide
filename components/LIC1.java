public class LIC1 {
    private double[] xList;
    private double[] yList;
    private int listLength;
    private double radius1;

    public LIC1() {
        // Empty constructor for testing purposes
    }

    public LIC1(double[] xList, double[] yList, double radius1) {
        this.xList = xList;
        this.yList = yList;
        this.listLength = xList.length;

        this.radius1 = radius1;
    }

    public boolean compute() {
        double diameter = 2 * radius1;
        boolean isOutsideTheCircle = false;

        for (int i = 0; i < listLength - 2; i++) {
            Point p1 = new Point(xList[i], yList[i]);
            Point p2 = new Point(xList[i + 1], yList[i + 1]);
            Point p3 = new Point(xList[i + 2], yList[i + 2]);

            double distanceBetweenP1P2 = computeDistance(p1, p2); // 1 - 2
            double distanceBetweenP2P3 = computeDistance(p2, p3); // 2 - 3
            double distanceBetweenP1P3 = computeDistance(p1, p3); // 1 - 3

            Point center;
            double angleCircumference;
            double angleCompare;

            if (distanceBetweenP1P2 > distanceBetweenP2P3 && distanceBetweenP1P2 > distanceBetweenP1P3) {
                // find center using point 1 and point 2
                center = findCircleCenter(p1, p2, radius1);
                // Compute angle at circumference
                angleCircumference = angleOnCircumference(p1, p2, center, radius1);
            } else if(distanceBetweenP2P3 > distanceBetweenP1P2 && distanceBetweenP2P3 > distanceBetweenP1P3) {
                // find center using point 2 and point 3
                center = findCircleCenter(p2, p3, radius1);
                // Compute angle at circumference
                angleCircumference = angleOnCircumference(p1, p2, center, radius1);
            } else {
                // find center using point 1 and point 3
                center = findCircleCenter(p1, p3, radius1);
                // Compute angle at circumference
                angleCircumference = angleOnCircumference(p1, p2, center, radius1);
            }
            // Compute angle at third point
            angleCompare = getAngleOn(p1, p2, p3);

            int comparator = angleComparator(angleCircumference, angleCompare);
            if (comparator == 1) {
                isOutsideTheCircle = true;
                break;
            }
//            isOutsideTheCircle = isOutsideTheCircle || comparator == 1 ? true : false;
        }

        return isOutsideTheCircle;
    }

    private double computeDistance(Point p1, Point p2) {
        double x1 = p1.x, y1 = p1.y;
        double x2 = p2.x, y2 = p2.y;

        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    private Point findCircleCenter(Point p1, Point p2, double radius1) {
        Point center = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        double distanceBetweenPoints = computeDistance(p1, p2);
        if ( distanceBetweenPoints == radius1) {
            // The diameter is the distance between the two points
            return center;
        }

        double mirrorDistance = Math.sqrt(radius1 * radius1 - distanceBetweenPoints * distanceBetweenPoints / 4);
        double dx = (p2.x - p1.x) * mirrorDistance / distanceBetweenPoints;
        double dy = (p2.y - p1.y) * mirrorDistance / distanceBetweenPoints;

        // modify the center
        center.x = center.x - dy;
        center.y = center.y + dx;

        return center;
    }

    private double angleOnCircumference(Point p1, Point p2, Point center, double radius1) {
        // Calculate x and y coordinate for the new point
        Point pointAcross = getPointOnCircumference(p1, center);

        // Compute angles
        double angleP1 = computeAngleAt(p1, p2, pointAcross);
        double angleP2 = computeAngleAt(p2, p1, pointAcross);
        // Angle sum of triangle = 180
        double anglePointAcross = 180 - (angleP1 + angleP2);

        return anglePointAcross;
    }

    private Point getPointOnCircumference(Point p, Point center) {
        double x = center.x - (p.x - center.x);
        double y = center.y - (p.y - center.y);
        return new Point(x, y);
    }

    private double computeAngleAt(Point A, Point B, Point C) {
        double a = computeDistance(A, B);
        double b = computeDistance(A, C);
        double c = computeDistance(B, C);

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

    private double getAngleOn(Point p1, Point p2, Point pointOutside) {
        double angleP1 = computeAngleAt(p1, p2, pointOutside);
        double angleP2 = computeAngleAt(p2, p1, pointOutside);
        // Sum of angles in triangle = 180
        double angleOutside = 180 - (angleP1 + angleP2);

        return angleOutside;
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

    public double cosineRule(Point A, Point B, Point C) {
        return computeAngleAt(A, B, C);
    }

    public Point publicFindCenter(Point p1, Point p2, double radius1) {
        return findCircleCenter(p1, p2, radius1);
    }
}
