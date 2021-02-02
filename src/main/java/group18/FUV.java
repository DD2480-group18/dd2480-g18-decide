package group18;

public class FUV {
    public static void main(String[] args) {
        // boolean[] puv = {false,true,false,true};
        // boolean[][] pum = {{false,false,false,false},{true,true,true,true},{false,false,false,false},{false,true,false,true}};
        boolean[] puv = {true,true,true,true};
        boolean[][] pum = {{false,false,false,false},{true,true,true,true},{true,true,true,true},{true,false,true,false}};
        boolean[] t = FUV.getFUV(puv, pum);
    }   
    
    public static boolean[] getFUV(boolean[] PUV, boolean[][] PUM){
        if (PUV == null || PUV.length != PUM[0].length) {
            throw new IllegalArgumentException("Dimensions of PUV needs to be correct");
        }
        boolean[] FUV = new boolean[PUV.length];
        for (int i = 0; i < FUV.length; i++) {
            if(PUV[i] == false){
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
        return FUV;
    }
}
