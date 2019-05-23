package coordinate;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;


public class LineTest {

	@Test
	public void Line이_길이를_제대로_계산하는지_검증() {
		Line line1 = new Line(Point.of(1, 1), Point.of(4, 1));
		assertThat(line1.length()).isEqualTo(3);

		Line line2 = new Line(Point.of(1,1), Point.of(2,2));
		assertThat(line2.length()).isEqualTo(1.414, offset(0.0099));
	}
}
