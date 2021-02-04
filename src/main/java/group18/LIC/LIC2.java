package group18.LIC;

/**
 * LIC2
 */
public class LIC2 {
    public static boolean getLic2(double [] xPos, double[] yPos, int numPoints,  double PI, double EPSILON){
        if (numPoints < 3 || Double.compare(EPSILON, PI) > 0) return false;
        double x1,x2,y1,y2;
        double angle=-1;
        double lenX;
        double leny;
        for (int i = 0; i < numPoints-2; i++) {

            if((xPos[i] == xPos[i+1] && yPos[i] == yPos[i+1])||(xPos[i+2] == xPos[i+1] && yPos[i+2] == yPos[i+1])){
                continue;
            }

            // vector BA
            x1 = xPos[i] - xPos[i+1];
            x2 = yPos[i] - yPos[i+1];
            // vector BC
            y1 = xPos[i+2] - xPos[i+1];
            y2 = yPos[i+2] - yPos[i+1];
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