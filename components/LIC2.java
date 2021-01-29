import java.lang.Math;


/**
 * LIC2
 */
public class LIC2 {
    public static void main(String[] args) {
        LIC2 l = new LIC2();
        double[] xCordinates = {4,1,1};
        double[] yCordinates = {2,1,3};
        l.getLic2(xCordinates,yCordinates,xCordinates.length, 3.1415926535, 2);
    }

    
    public boolean getLic2(double [] xPos, double[] yPos, int numPoints,  double PI, double EPSILON){
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
            // System.out.println("A(" + xPos[i] + "," + yPos[i] + ")");
            // System.out.println("B(" + xPos[i+1] + "," + yPos[i+1] + ")");
            // System.out.println("C(" + xPos[i+2] + "," + yPos[i+2] + ")");
            // System.out.println("x1: " + x1 + " x2: " + x2 +"y1: " + y1 + " y2: " + y2);
            lenX = Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
            leny = Math.sqrt(Math.pow(y1, 2) + Math.pow(y2, 2)); 

            angle = Math.acos((x1*y1+x2*y2)/(lenX*leny));

            if(angle < PI - EPSILON){
                // System.out.println("SIG angle: " + angle*180/Math.PI);
                return true;
            }
            
            // System.out.println("angle: " + angle);

        }
        return false;
    }

}