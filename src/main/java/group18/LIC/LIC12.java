package main.java.group18.LIC;

public class LIC12 {
    private static boolean condition1;
    private static boolean condition2;

    public static void setCondition1(boolean b) {
        condition1 = b;
    }

    public static void setCondition2(boolean b) {
        condition2 = b;
    }

    /**
     * Help function to calculate distance between two points
     *
     * @param pt1: a 2-D point consisting of two doubles
     * @param pt2: a 2-D point consisting of two doubles
     * @return the distance (as a double) between the two points
     */

    private static double getDist(double[] pt1, double[] pt2) {
        return Math.sqrt(Math.pow(pt1[0] - pt2[0], 2) + Math.pow(pt1[1] - pt2[1], 2));
    }

    /**
     * This function implements the functionality of launch initiation condition 6.
     * It returns true if there is one set of two points, separated by K_PTS consecutive intervening points, farther
     * apart than LENGTH1 as well as at least one set of two points, separated by K_PTS consecutive intervening points,
     * closer to each other than LENGTH2. If only one condition is fulfilled, the function returns false.
     *
     * @param xs: double array holding the x-coordinates
     * @param ys: double array holding the y-coordinates
     * @param NUM_POINTS: integer holding the number of points in total
     * @param K_PTS: integer holding the number of points separating two points in a set
     * @param LENGTH1: double holding the minimum distance for two points to be separated to satisfy condition 1
     * @param LENGTH2: double holding the minimum distance for two points to be separated to satisfy condition 2
     * @return true if both conditions are met, false otherwise
     */
    public static boolean getCondition(double[] xs, double[] ys, int NUM_POINTS, int K_PTS, double LENGTH1, double LENGTH2) {
        if (NUM_POINTS < 3 || LENGTH2 <= 0 || K_PTS > NUM_POINTS) return false;
        double[] pt_1;
        double[] pt_2;
        double dist;
        for (int i = 0; i < NUM_POINTS - K_PTS; i++) {
            pt_1 = new double[] {xs[i], ys[i]};
            pt_2 = new double[] {xs[i+K_PTS], ys[i+K_PTS]};
            dist = getDist(pt_1, pt_2);
            if (dist > LENGTH1 && dist < LENGTH2) return true;
            else if (dist > LENGTH1) condition1 = true;
            else if (dist < LENGTH2) condition2 = true;
            System.out.println("condition1: " + condition1 + "\ncondition2: " + condition2 + "\n");
        }
        System.out.println("\n");
        return condition1 && condition2;
    }
}
