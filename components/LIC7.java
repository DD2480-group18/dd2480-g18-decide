import java.lang.Math;

public class LIC7 {
    // The value to be returned to the CMV
    private static boolean condition = false;

    /**
     * This condition returns true if two consecutive points are closer together than a given length
     *
     * @param xs: an array of doubles containing the x-coordinates
     * @param ys: an array of doubles containing the y-coordinates
     * @param numpoints: a number representing the number of points.
     * @param distance: a number representing the maximum allowed distance between two points
     * @param K_pts: a number representing the maximum allowed distance between two points
     */
    public static boolean getCondition(double[] xs, double[] ys, int numpoints, double distance, int K_pts) {
        if(numpoints < 3 || !((1 <= K_pts) && (K_pts <= numpoints-2))){
            return condition;
        }
        for (int i = 0; i < numpoints-1-K_pts; i ++) {
            double d = Math.sqrt(Math.pow(xs[i] - xs[i + 1 + K_pts], 2) + Math.pow(ys[i] - ys[i + 1 + K_pts], 2));
            if (d > distance) {
                condition = true;
                break;
            }
        }
        return condition;
    }
}