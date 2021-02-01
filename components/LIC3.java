public class LIC3 {
    private static boolean condition = false;

    private static double dotProduct(double[] v1, double[] v2) {
        return v1[0]*v2[0] + v1[1]*v2[1];
    }

    private static double vecLen(double[] v) {
        return Math.sqrt(Math.pow(v[0], 2) + Math.pow(v[1], 2));
    }

    public static boolean getCondition(double[] xs, double[] ys, double AREA1) {
        double[] p1;
        double[] p2;
        double[] p3;
        double[] v1;
        double[] v2;
        double v1Len;
        double v2Len;
        double angle;
        double height;
        double area;
        for (int i = 0; i < xs.length - 2; i++) {
            p1 = new double[] {xs[i], ys[i]};
            p2 = new double[] {xs[i + 1], ys[i + 1]};
            p3 = new double[] {xs[i + 2], ys[i + 2]};
            v1 = new double[] {p1[0] - p2[0], p1[1] - p2[1]};
            v2 = new double[] {p1[0] - p3[0], p1[1] - p3[1]};
            v1Len = vecLen(v1);
            v2Len = vecLen(v2);
            angle = Math.acos(dotProduct(v1, v2)/(v1Len*v2Len));
            height = Math.sin(angle)*v2Len;
            area = v1Len*height/2;
            if (area > AREA1) {
                condition = true;
                break;
            }
        }
        return condition;
    }
}
