package group18;

import group18.parameters.CONNECTORS;

import java.util.Arrays;

import static group18.parameters.CONNECTORS.*;

/**
 * This is the main function for the project. DECIDE() returns true whether or not 
 * we are gonna fire an interceptor based on coordinates and parameters. 
 *
 */
public class Main 
{
    public static void DECIDE(Values inputValues) {
        Values values = inputValues;
        values.CMV.VECTOR = CMV.calculate(values);
        values.PUM.BMATRIX = PUM.getPUM(values.CMV.VECTOR, values.LCM.CMATRIX);
        values.FUV.VECTOR = FUV.getFUV(values.PUV.VECTOR, values.PUM.BMATRIX);
        values.LAUNCH = Launch.launch(values.FUV.VECTOR);
        if(values.LAUNCH)
            System.out.println("YES");
        else
            System.out.println("NO");
        // debugPrints();
    }

    public static void debugPrints(Values values){
        System.err.println(Arrays.toString(values.CMV.VECTOR));
        for (int i = 0; i < 15; i++) {
            System.err.println("\t" + Arrays.toString(values.PUM.BMATRIX[i]));
        }
        System.err.println(Arrays.toString(values.FUV.VECTOR));
    }
}
