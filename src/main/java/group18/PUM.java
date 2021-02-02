package group18;

import static group18.parameters.CONNECTORS.*;

public class PUM {
    public static boolean[][] getPUM(boolean[] CMV, group18.parameters.CONNECTORS[][] LCM) {
        boolean[][] pum = new boolean[15][15];
        for (int i = 0; i < CMV.length; i++) {
            for (int j = 0; j < CMV.length; j++) {
                if (i == j) continue;
                if (LCM[i][j] == ANDD) pum[i][j] = CMV[i] && CMV[j];
                else if (LCM[i][j] == ORR) pum[i][j] = CMV[i] || CMV[j];
                else if (LCM[i][j] == NOTUSED) pum[i][j] = true;
            }
        }
        return pum;
    }
}
