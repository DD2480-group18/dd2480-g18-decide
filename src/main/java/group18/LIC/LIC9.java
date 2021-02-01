package group18.LIC;

/**
 * LIC2
 */
public class LIC9 {
    public static void main(String[] args) {
        LIC9 l = new LIC9();
        double[] xCordinates = {4,0,0,0,1,0,0,1};
        double[] yCordinates = {2,0,0,0,1,0,0,3};
        l.getLic9(xCordinates,yCordinates,xCordinates.length,3,2,3.1415926535, 2);
    }

    
    public boolean getLic9(double [] xPos, double[] yPos, int numPoints, int C_PTS, int D_PTS, double PI, double EPSILON){
        double x1,x2,y1,y2;
        double angle=-1;
        double lenX;
        double leny;
        if(numPoints < 5){
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
            System.out.println("A(" + xPos[i] + "," + yPos[i] + ")");
            System.out.println("B(" + xPos[i+C_PTS+1] + "," + yPos[i+C_PTS+1] + ")");
            System.out.println("C(" + xPos[i+C_PTS+D_PTS+2] + "," + yPos[i+C_PTS+D_PTS+2] + ")");
            System.out.println("x1: " + x1 + " x2: " + x2 +"y1: " + y1 + " y2: " + y2);
            lenX = Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
            leny = Math.sqrt(Math.pow(y1, 2) + Math.pow(y2, 2)); 

            angle = Math.acos((x1*y1+x2*y2)/(lenX*leny));

            if(angle < PI - EPSILON){
                System.out.println("SIG angle: " + angle*180/Math.PI);
                return true;
            }
            
            System.out.println("angle: " + angle);

        }
        return false;
    }

}

// A(4.0,2.0)
// B(1.0,1.0)
// C(1.0,3.0)
// x1: 3.0 x2: 1.0y1: 0.0 y2: 2.0
// angle: 1.2490457723982544