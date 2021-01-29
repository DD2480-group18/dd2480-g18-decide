import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
	@Test
	public void addition() {
		Example example = new Example();
		assertEquals(2, example.add(1,1));
	}
}
