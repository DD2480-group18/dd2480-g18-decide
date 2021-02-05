package group18.LIC;

public class LIC11 {
    public static boolean getLic11(double [] xPos, double[] yPos, int numPoints, int G_pts){
        if(numPoints < 3 || G_pts < 1 || G_pts > numPoints - 2){
            return false;
        }
        for (int i = 0; i < numPoints-1-G_pts; i++) {
            if(xPos[i+G_pts+1] - xPos[i] < 0){
                return true;
            }
        }
        return false;
    }
}
