package group18.LIC;

public class LIC5 {
    public static void main(String[] args) {
        LIC5 l = new LIC5();
        double[] xCordinates = {4,1,1};
        double[] yCordinates = {2,1,3};
        l.getLic5(xCordinates,yCordinates,xCordinates.length);
    }

    
    public boolean getLic5(double [] xPos, double[] yPos, int numPoints){
        for (int i = 0; i < numPoints-1; i++) {
            // System.out.println("x[i]: " + xPos[i] + " x[j]: " + xPos[i+1] + " x[j]-x[i]: " + (xPos[i+1]-xPos[i]));
            if(xPos[i+1] - xPos[i] < 0){
                return true;
            }
        }
        return false;
    }
}
