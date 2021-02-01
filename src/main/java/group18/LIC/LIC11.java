package group18.LIC;

public class LIC11 {
    public static void main(String[] args) {
        LIC11 l = new LIC11();
        double[] xCordinates = {1,0,0,2,3};
        double[] yCordinates = {2,0,0,1,3};
        l.getLic11(xCordinates,yCordinates,xCordinates.length, 2);
    }

    
    public boolean getLic11(double [] xPos, double[] yPos, int numPoints, int G_pts){
        for (int i = 0; i < numPoints-1-G_pts; i++) {
            // System.out.println("x[i]: " + xPos[i] + " x[j]: " + xPos[i+G_pts+1] + " x[j]-x[i]: " + (xPos[i+G_pts+1]-xPos[i]));
            if(xPos[i+G_pts+1] - xPos[i] < 0){
                return true;
            }
        }
        return false;
    }
}
