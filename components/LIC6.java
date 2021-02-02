import java.lang.Math;

public class LIC6 {
    public static void main(String[] args) {
        int NUMPOINTS = 8;
        double[] xCoordinates = {4,0,0,0,1,-3,0,1};
        double[] yCoordinates = {2,0,0,0,1,-12,0,3};
        // true
        boolean licRes = LIC6.getLic6(xCoordinates,yCoordinates,NUMPOINTS,6,2);
    }


    public static boolean getLic6(double [] xPos, double[] yPos, int NUMPOINTS, int N_PTS, double DIST){
        double x1,x2,y1,y2;     // the two points forming a line, first and last of N_PTS
        double k, m, a, b, c;   // variables to describe the line
        double x0, y0;          // the intermediate point whose distance is being examined
        double distToLine;

        // condition is only met when NUMPOINTS is at least 3
        if(NUMPOINTS < 3){
            return false;
        }
        int offset = N_PTS-1; // we want the first and last of N_PTS, not N_PTS inbetween
        for (int i = 0; i < NUMPOINTS-offset; i++) {
            x1 = xPos[i];
            x2 = xPos[i+offset];
            y1 = yPos[i];
            y2 = yPos[i+offset];
            k = (y2 - y1)/(x2 - x1);
            m = y1 - k*x1;
            // y = kx + m
            // -kx + 1*y - m = 0
            // ax + by + c = 0
            // a = -k, b = 1, c = -m
            a = -k;
            b = 1;
            c = -m;

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
