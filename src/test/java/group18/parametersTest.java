package group18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import group18.parameters.*;

public class parametersTest {
	@Test
	void testCONNECTORS(){
		// 3 different values with defined names
		CONNECTORS con = CONNECTORS.ANDD;
		assertEquals(CONNECTORS.ANDD, con);
		con = CONNECTORS.NOTUSED;
		assertEquals(CONNECTORS.NOTUSED, con);
		con = CONNECTORS.ORR;
		assertEquals(CONNECTORS.ORR, con);
		assertNotEquals(CONNECTORS.ANDD, con);
		assertNotEquals(CONNECTORS.NOTUSED, con);
	}

	@Test
	void testCOORDINATE(){
		// 100 length array
		COORDINATE coord = new COORDINATE();
		assertEquals(coord.COORDINATE.length, 100);
		for (int i = 0; i < 100; i++) {
			assertEquals(coord.COORDINATE[i], 0);
		}
	}

	@Test
	void testCMATRIX(){
		// 15x15 matrix
		CMATRIX matrix = new CMATRIX();
		assertEquals(matrix.CMATRIX.length, 15);
		for (int i = 0; i < 15; i++) {
			assertEquals(matrix.CMATRIX[i].length, 15);
		}
	}

	@Test
	void testBMATRIX(){
		// 15x15 matrix
		BMATRIX matrix = new BMATRIX();
		assertEquals(matrix.BMATRIX.length, 15);
		for (int i = 0; i < 15; i++) {
			assertEquals(matrix.BMATRIX[i].length, 15);
		}
	}

	@Test
	void testVECTOR(){
		// check if vector created and right length
		VECTOR vector = new VECTOR();
		assertEquals(vector.VECTOR.length, 15);
	}

	@Test
	void testCOMPTYPE(){
		// 3 different values with defined names
		COMPTYPE comptype = COMPTYPE.EQ;
		assertEquals(COMPTYPE.EQ, comptype);
		comptype = COMPTYPE.GT;
		assertEquals(COMPTYPE.GT, comptype);
		comptype = COMPTYPE.LT;
		assertEquals(COMPTYPE.LT, comptype);
		assertNotEquals(COMPTYPE.EQ, comptype);
		assertNotEquals(COMPTYPE.GT, comptype);
	}

	@Test
	void testPARAMETER_T(){
		// check if all variables present
		PARAMETERS_T parameters_t = new PARAMETERS_T();
		assertEquals(parameters_t.LENGTH1,0);
		assertEquals(parameters_t.LENGTH2, 0);
		assertEquals(parameters_t.RADIUS1, 0);
		assertEquals(parameters_t.RADIUS2, 0);
		assertEquals(parameters_t.AREA1, 0);
		assertEquals(parameters_t.AREA2, 0);
		assertEquals(parameters_t.EPSILON, 0);
		assertEquals(parameters_t.DIST, 0);
		assertEquals(parameters_t.Q_PTS, 0);
		assertEquals(parameters_t.QUADS, 0);
		assertEquals(parameters_t.N_PTS, 0);
		assertEquals(parameters_t.K_PTS, 0);
		assertEquals(parameters_t.A_PTS, 0);
		assertEquals(parameters_t.B_PTS, 0);
		assertEquals(parameters_t.C_PTS, 0);
		assertEquals(parameters_t.D_PTS, 0);
		assertEquals(parameters_t.E_PTS, 0);
		assertEquals(parameters_t.F_PTS, 0);
		assertEquals(parameters_t.G_PTS, 0);
	}

	@Test
	void testDOUBLECOMPARE(){
		// test comparison is done correctly
		assertEquals(DOUBLECOMPARE.doubleCompare(1,2), COMPTYPE.LT);
		assertEquals(DOUBLECOMPARE.doubleCompare(2,1), COMPTYPE.GT);
		assertEquals(DOUBLECOMPARE.doubleCompare(1.0, 1.0000001), COMPTYPE.EQ);
	}

	@Test
	void testValues(){
		// check to see if all values exists and are initialised
		Values values = new Values();
		assertEquals(values.PI, 3.1415926535);
		assertNotEquals(values.PARAMETERS, null);
		assertNotEquals(values.X, null);
		assertNotEquals(values.Y, null);
		assertEquals(values.NUMPOINTS, 0);
		assertNotEquals(values.LCM, null);
		assertNotEquals(values.PUM, null);
		assertNotEquals(values.CMV, null);
		assertNotEquals(values.FUV, null);
		assertEquals(values.LAUNCH, false);


	}
}
