package group18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CMVTest {
	@Test
	void testReturn(){
		CMV cmv = new CMV();
		Values values = new Values();
		boolean[] ret = cmv.calculate(values);

		for (int i = 0; i < 15; i++) {
			assertFalse(ret[i]);
		}
	}
}
