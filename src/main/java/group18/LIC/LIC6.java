package group18.LIC;

import java.lang.Math;

public class LIC6 {
    public static boolean getLic6(double [] xPos, double[] yPos, int NUMPOINTS, int N_PTS, double DIST) {
        double x1,x2,y1,y2;     // the two points forming a line, first and last of N_PTS
        double dx, dy;          // used to calculate the slope, k
        double k, m, a, b, c;   // variables to describe the line
        double x0, y0;          // the intermediate point whose distance is being examined
        double distToLine;
        boolean dxZero = false; // used to prevent division by zero when handling vertical lines

        // condition is only met when NUMPOINTS is at least 3
        if (NUMPOINTS < 3) {
            return false;
        }
        int offset = N_PTS-1; // we want the first and last of N_PTS, not N_PTS inbetween
        for (int i = 0; i < NUMPOINTS-offset; i++) {
            x1 = xPos[i];
            x2 = xPos[i+offset];
            y1 = yPos[i];
            y2 = yPos[i+offset];
            dx = x2 - x1;
            dy = y2 - y1;
            dxZero = (Math.abs(dx) < Math.pow(10, -6));

            // y = kx + m
            // -kx +    1*y     - m = 0
            // ax   +   by      + c = 0
            // regular case:
            // a = -k,  b = 1,  c = -m
            if (dxZero) {
                // a vertical line, its normal will
                // be zero in y-direction and has no y-intercept (m=0=c)
                // its x-component only needs to be non-zero so that it's
                // possible to project on it and since the distance formula normalizes
                a = 1;
                b = 0;
                c = 0;
            } else { // regular case
                k = dy / dx;
                m = y1 - k * x1;
                a = -k;
                b = 1;
                c = -m;
            }

            for (int j = i + 1; j < i + offset; j++) {
                x0 = xPos[j];
                y0 = yPos[j];

                // the points creating the line are identical - use regular Euclidean distance
                if (Double.compare(x1, x2) == 0 && Double.compare(y1, y2) == 0) {
                    distToLine = Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2) );
                }
                // regular case, the points creating the line are different
                else{
                    // let QP be a line between Q=(x1, y1) and P=(x0, y0)
                    // and let n = [a, b] be the normal to the line
                    // we can then project QP to n and divide by the length of the normal
                    // d = | QP * n | / ||n||
                    // d = | a*x0 + b*y0 + c | /  -/(a^2 + b^2)
                    distToLine = Math.abs(a*x0 + b*y0 + c) / Math.sqrt(a * a + b * b);
                }

                // final check for the intermediate point
                if (distToLine > DIST) {
                    return true;
                }
            }
        }
        // no points at a distance greater than DIST were found
        return false;
    }

}
