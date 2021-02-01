package group18.LIC;

public class LIC0 {
    // The value to be returned to the CMV
    private static boolean condition = false;

    /**
     * This condition returns true if two consecutive points are closer together than a given length
     *
     * @param xs: an array of doubles containing the x-coordinates
     * @param ys: an array of doubles containing the y-coordinates
     * @param distance: a number representing the maximum allowed distance between two points
     */

    public static boolean getCondition(double[] xs, double[] ys, double distance) {
        for (int i = 0; i < xs.length-1; i ++) {
            double d = Math.sqrt(Math.pow(xs[i] - xs[i + 1], 2) + Math.pow(ys[i] - ys[i + 1], 2));
            if (d > distance) {
                condition = true;
                break;
            }
        }
        return condition;
    }
}
