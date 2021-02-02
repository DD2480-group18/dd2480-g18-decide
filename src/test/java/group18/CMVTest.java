package group18;

import group18.LIC.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CMVTest {
	@Test
	void testReturn(){
		// this tests checks if CMV output is the same as all of the LIC output
		Values values = new Values();
		boolean[] LICs = new boolean[15];
		LICs[0] = LIC0.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.DIST);
		LICs[1] = LIC1.compute(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.RADIUS1, values.NUMPOINTS);
		LICs[2] = LIC2.getLic2(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PI, values.PARAMETERS.EPSILON);
		LICs[3] = LIC3.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.AREA1, values.NUMPOINTS);
		LICs[4] = LIC4.lic4(values.PARAMETERS.Q_PTS, values.PARAMETERS.QUADS, values.X.COORDINATE, values.Y.COORDINATE);
		LICs[5] = LIC5.getLic5(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS);
		LICs[6] = LIC6.getLic6(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PARAMETERS.N_PTS, values.PARAMETERS.DIST);
		LICs[7] = LIC7.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PARAMETERS.DIST, values.PARAMETERS.K_PTS);
		LICs[8] = LIC8.compute(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.RADIUS1, values.PARAMETERS.A_PTS, values.PARAMETERS.B_PTS, values.NUMPOINTS);
		LICs[9] = LIC9.getLic9(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PARAMETERS.C_PTS, values.PARAMETERS.D_PTS, values.PI, values.PARAMETERS.EPSILON);
		LICs[10] = LIC10.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.AREA1, values.PARAMETERS.E_PTS, values.PARAMETERS.F_PTS, values.NUMPOINTS);
		LICs[11] = LIC11.getLic11(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PARAMETERS.G_PTS);
		LICs[12] = LIC12.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.NUMPOINTS, values.PARAMETERS.K_PTS, values.PARAMETERS.LENGTH1, values.PARAMETERS.LENGTH2);
		LICs[13] = LIC13.compute(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.RADIUS1, values.PARAMETERS.RADIUS2, values.PARAMETERS.A_PTS, values.PARAMETERS.B_PTS, values.NUMPOINTS);
		LICs[14] = LIC14.getCondition(values.X.COORDINATE, values.Y.COORDINATE, values.PARAMETERS.AREA1, values.PARAMETERS.AREA2, values.PARAMETERS.E_PTS, values.PARAMETERS.F_PTS, values.NUMPOINTS);
		boolean[] ret = new boolean[15];
		ret = CMV.calculate(values);
		assertArrayEquals(ret, LICs);
	}
}
