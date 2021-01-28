import java.lang.Math;


/**
 * LIC2
 */
public class LIC2 {
    public static void main(String[] args) {
        LIC2 l = new LIC2();
        l.getLic2(3.1415926535, 2);
    }

    public boolean getLic2(double PI, double EPSILON){

        double[] xCordinates = {0,0,-1,3,6,3,6,8,6,53,1};
        double[] yCordinates = {1,0,0,6,8,0,23,6,3,1,2}; 

        double x1,x2,y1,y2;
        double angle=-1;
        double lenX;
        double leny;
        for (int i = 0; i < yCordinates.length-2; i++) {

            if((xCordinates[i] == xCordinates[i+1] && yCordinates[i] == yCordinates[i+1])||(xCordinates[i+2] == xCordinates[i+1] && yCordinates[i+2] == yCordinates[i+1])){
                continue;
            }

            // vector BA
            x1 = xCordinates[i] - xCordinates[i+1];
            x2 = yCordinates[i] - yCordinates[i+1];
            // vector BC
            y1 = xCordinates[i+2] - xCordinates[i+1];
            y2 = yCordinates[i+2] - yCordinates[i+1];
            System.out.println("A(" + xCordinates[i] + "," + yCordinates[i] + ")");
            System.out.println("B(" + xCordinates[i+1] + "," + yCordinates[i+1] + ")");
            System.out.println("C(" + xCordinates[i+2] + "," + yCordinates[i+2] + ")");
            System.out.println("x1: " + x1 + " x2: " + x2 +"y1: " + y1 + " y2: " + y2);
            lenX = Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
            leny = Math.sqrt(Math.pow(y1, 2) + Math.pow(y2, 2)); 

            angle = Math.acos((x1*y1+x2*y2)/(lenX*leny));

            if(angle < PI - EPSILON){
                System.out.println("SIG ");
                return true;
            }
            
            System.out.println("angle: " + angle);

        }

        return false;
    }

}