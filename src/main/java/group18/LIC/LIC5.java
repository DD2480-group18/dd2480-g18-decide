package group18.LIC;

public class LIC5 {
    public static boolean getLic5(double [] xPos, double[] yPos, int numPoints){
        if (numPoints < 2) return false;
        for (int i = 0; i < numPoints-1; i++) {
            if(xPos[i+1] - xPos[i] < 0){
                return true;
            }
        }
        return false;
    }
}
