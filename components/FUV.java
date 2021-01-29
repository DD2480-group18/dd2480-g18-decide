
public class FUV {
    public static void main(String[] args) {
        boolean[] puv = {false,true,false,true};
        boolean[][] pum = {{false,false,false,false},{true,true,true,true},{false,false,false,false},{false,true,false,true}};

        boolean[] t = FUV.getFUV(puv, pum);
    }   
    
    public static boolean[] getFUV(boolean[] PUV, boolean[][] PUM){
        boolean[] FUV = new boolean[PUV.length];

        for (int i = 0; i < FUV.length; i++) {
            System.out.println("i: " + i);
            if(PUV[i] == false){
                System.out.println("PUV[i] == false: " + FUV[i]);
                FUV[i] = true;
                continue;
            } else {
                for (int j = 0; j < PUM[i].length; j++) {
                    if(PUM[i][j] == false) {

                        FUV[i] = false;
                        break;
                    }
                    if(j == PUM[i].length-1){
                        FUV[i] = true;
                    }
                }
            }
            
        }
        for (int i = 0; i < FUV.length; i++) {
            System.out.println(FUV[i]);
        }
        return null;
    }
}
