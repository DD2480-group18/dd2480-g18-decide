public class LIC3 {
    private static boolean condition = false;

    private static double dotProduct(double[] v1, double[] v2) {
        return v1[0]*v2[0] + v1[1]*v2[1];
    }

    private static double vecLen(double[] v) {
        return Math.sqrt(Math.pow(v[0], 2) + Math.pow(v[1], 2));
    }

    public static boolean getCondition(double[] xs, double[] ys, double AREA1) {
        for (int i = 0; i < xs.length - 2; i++) {
            double[] p1 = {xs[i], ys[i]};
            double[] p2 = {xs[i+1], ys[i+1]};
            double[] p3 = {xs[i+2], ys[i+2]};
            double[] v1 = {p1[0]-p2[0], p1[1]-p2[1]};
            double[] v2 = {p1[0]-p3[0], p1[1]-p3[1]};
            double v1Len = vecLen(v1);
            double v2Len = vecLen(v2);
            double angle = Math.acos(dotProduct(v1, v2)/(v1Len*v2Len));
            double height = Math.sin(angle)*v2Len;
            double area = v1Len*height/2;
            if (area > AREA1) {
                condition = true;
                break;
            }
        }
        return condition;
    }
}
