package group18;

import group18.parameters.CONNECTORS;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PUMTest {
    @Test
    void testPUM1() {
        Random rnd = new Random();
        boolean[] CMV = new boolean[15];
        CONNECTORS[][] LCM = new CONNECTORS[15][15];
        for (int i = 0; i < LCM.length; i++) {
            CMV[i] = rnd.nextBoolean();
            for (int j = 0; j < LCM[i].length; j++) {
                int rndIdx = rnd.nextInt(3);
                if (i == j) LCM[i][j] = CONNECTORS.ANDD;
                else if (rndIdx == 0) LCM[i][j] = CONNECTORS.NOTUSED;
                else if (rndIdx == 1) LCM[i][j] = CONNECTORS.ANDD;
                else LCM[i][j] = CONNECTORS.ORR;
            }
            System.out.println(Arrays.toString(LCM[i]));
        }
        System.out.println(Arrays.toString(CMV));
        boolean[][] pum = group18.PUM.getPUM(CMV, LCM);
        for (boolean[] row : pum) {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < pum.length; i++) {
            for (int j = 0; j < pum[i].length; j++) {
                if (i == j) continue;
                if (LCM[i][j] == CONNECTORS.ANDD) assertEquals(CMV[i] && CMV[j], pum[i][j]);
                else if (LCM[i][j] == CONNECTORS.ORR) assertEquals(CMV[i] || CMV[j], pum[i][j]);
                else if (LCM[i][j] == CONNECTORS.NOTUSED) assertTrue(pum[i][j]);
            }
        }
    }
}
