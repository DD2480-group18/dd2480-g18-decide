package group18;

import group18.LIC.*;

public class CMV {
	public boolean[] calculate(Values values){
		boolean[] LICs = new boolean[15];

		// add the functions here
		LICs[0] = LIC0.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.DIST);
		LICs[1] = false; //LIC2.getLic2(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PI, values.PARAMETERS.EPSILON); need to be static
		LICs[2] = LIC3.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.AREA1, values.NUMPOINTS);
		LICs[3] = false; //needs to be static
		LICs[4] = false; //LIC5 needs to be static
		LICs[5] = LIC6.getLic6(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PARAMETERS.N_PTS, values.PARAMETERS.DIST);
		LICs[6] = false; // not here yet
		LICs[7] = false; // not here yet
		LICs[8] = false; // lic9 needs to be static
		LICs[9] = LIC10.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.AREA1, values.PARAMETERS.E_PTS, values.PARAMETERS.F_PTS, values.NUMPOINTS);
		LICs[10] = false; // lic10 needs to be static
		LICs[11] = LIC12.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PARAMETERS.K_PTS, values.PARAMETERS.LENGTH1, values.PARAMETERS.LENGTH2);
		LICs[12] = false; // not here yet
		LICs[13] = false; // not here yet
		LICs[14] = false; // not here yet

		return LICs;
	}


}