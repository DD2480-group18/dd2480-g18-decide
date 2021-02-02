package group18;

import group18.parameters.*;

public class Values {
	// constant
	public final double PI = 3.1415926535;

	public PARAMETERS_T PARAMETERS = new PARAMETERS_T();
	public double[] X = {};
	public double[] Y = {};
	public int NUMPOINTS;
	public CMATRIX LCM = new CMATRIX();
	public BMATRIX PUM = new BMATRIX();
	public VECTOR CMV = new VECTOR();
	public VECTOR FUV = new VECTOR();
	public VECTOR PUV = new VECTOR();
	boolean LAUNCH;

	public void init(double[] x, double[] y, int numpoints, CONNECTORS[][] lcm, boolean[] puv){
		X = x;
		Y = y;
		NUMPOINTS = numpoints;
		LCM.CMATRIX = lcm;
		PUV.VECTOR = puv;
	}
}
