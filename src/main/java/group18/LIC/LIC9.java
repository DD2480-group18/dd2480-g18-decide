package group18.LIC;

/**
 * LIC9
 */
public class LIC9 {
    public static boolean getLic9(double [] xPos, double[] yPos, int numPoints, int C_PTS, int D_PTS, double PI, double EPSILON){
        double x1,x2,y1,y2;
        double angle=-1;
        double lenX;
        double leny;
        if(numPoints < 5 || 1 > C_PTS || 1 > D_PTS || (C_PTS + D_PTS) < numPoints -3){
            return false;
        }
        for (int i = 0; i < numPoints-2-C_PTS-D_PTS; i++) {

            if((xPos[i] == xPos[i+C_PTS+1] && yPos[i] == yPos[i+C_PTS+1])||(xPos[i+C_PTS+D_PTS+2] == xPos[i+C_PTS+1] && yPos[i+C_PTS+D_PTS+2] == yPos[i+C_PTS+1])){
                continue;
            }

            // vector BA
            x1 = xPos[i] - xPos[i+C_PTS+1];
            x2 = yPos[i] - yPos[i+C_PTS+1];
            // vector BC
            y1 = xPos[i+C_PTS+D_PTS+2] - xPos[i+C_PTS+1];
            y2 = yPos[i+C_PTS+D_PTS+2] - yPos[i+C_PTS+1];
            lenX = Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
            leny = Math.sqrt(Math.pow(y1, 2) + Math.pow(y2, 2)); 

            angle = Math.acos((x1*y1+x2*y2)/(lenX*leny));

            if(angle < PI - EPSILON){
                return true;
            }

        }
        return false;
    }

}
