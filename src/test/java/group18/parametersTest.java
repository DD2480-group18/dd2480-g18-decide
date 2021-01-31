package group18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import group18.parameters.*;

public class parametersTest {
	@Test
	void testCONNECTORS(){
		// three possible distinct values
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
		COORDINATE coord = new COORDINATE();
		assertEquals(coord.COORDINATE.length, 100);
		for (int i = 0; i < 100; i++) {
			assertEquals(coord.COORDINATE[i], 0);
		}
	}
}
