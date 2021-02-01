import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;



public class FUVTest {
    /**
     * PUV = [1,1,1,1]
     * PUM =[[0,0,0,0]
     *       [1,1,1,1]
     *       [1,1,1,1]
     *       [1,0,1,0]]
     * FUV[0] should be 0 since PUV[0] = 1 and PUM[0][i] = 0 for all i in range
     * FUV[1] should be 1 since PUV[1] = 1 and PUM[0][i] = 1 for all i in range
     * FUV[2] should be 1 since PUV[2] = 1 and PUM[2][i] = 1 for all i in range
     * FUV[3] should be 0 since PUV[3] = 1 and PUM[3][1] = 0
     * INCORRECT FUV = [1,1,1,1]
     * SUPPOSED TO BE FUV = [0,1,1,0]
     */
    @Test
    void falseTest() {
        boolean[] puv = {true,true,true,true};
        boolean[][] pum = {{false,false,false,false},{true,true,true,true},{true,true,true,true},{true,false,true,false}};
        FUV a = new FUV();
        boolean[] incorrectFUV = {true,true,true,true};
        boolean[] calcFUV = a.getFUV(puv,pum);
        asserFalse(Arrays.equals(incorrectFUV, calcFUV ));
    }

    /**
     * PUV = [0,1,0,1]
     * PUM =[[0,0,0,0]
     *       [1,1,1,1]
     *       [1,1,1,1]
     *       [1,0,1,0]]
     * FUV[0] should be 1 since PUV[0] = 0
     * FUV[1] should be 1 since PUM[1][i] = 1 for all i in range
     * FUV[2] should be 1 since PUV[2] = 0 and PUM[2][i] = 1 for all i in range
     * FUV[3] should be 0 since PUV[3] = 1 and PUM[3][1] = 0
     * FUV = [1,1,1,0]
     */
    @Test
    void trueTest() {
        boolean[] puv = {false,true,false,true};
        boolean[][] pum = {{false,false,false,false},{true,true,true,true},{true,true,true,true},{true,false,true,false}};
        FUV a = new FUV();
        boolean[] correctFUV = {true,true,true,false};
        boolean[] calcFUV = a.getFUV(puv,pum);
        asserTrue(Arrays.equals(correctFUV, calcFUV ));
    }

    /**
     * Test checks whether an error is thrown when dimensions of PUVi is incorrect 
     */
    @Test
    void invalidInput() {
        boolean[] puv = {false,true,false};
        boolean[][] pum = {{false,false,false,false},{true,true,true,true},{true,true,true,true},{true,false,true,false}};
        FUV a = new FUV();
        boolean[] correctFUV = {true,true,true,false};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> a.getFUV(puv,pum));
        assertEquals("Dimensions of PUV needs to be correct", exception.getMessage());
}
    }
}

