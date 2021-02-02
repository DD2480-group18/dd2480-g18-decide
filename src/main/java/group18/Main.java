package group18;

/**
 * This is the main function for the project. DECIDE() returns true whether or not 
 * we are gonna fire an interceptor based on coordinates and parameters. 
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        DECIDE(null);
    }

    private static DECIDE(Values inputValues) {
        Values values = inputValues;
        values.CMV.VECTOR = CMV.calculate(values); 
        values.PUM.BMATRIX = PUM.getPUM(values.CMV.VECTOR, values.LCM.CMATRIX);
        values.FUV.VECTOR = FUV.getFUV(values.PUV.VECTOR, values.PUM.BMATRIX);
        values.LAUNCH = Launch.launch(values.FUV.VECTOR);
    }
}
