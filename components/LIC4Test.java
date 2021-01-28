import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LIC4Test {
	@Test
	void addition() {
		LIC4 test = new LIC4();
		double[] X = {1,-1};
		double[] Y = {1,-1};
		assertEquals(true, test.lic4(2, 1, X, Y));
	}
}