package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;


public class LineTest {

	@Test
	public void Line이_길이를_제대로_계산하는지_검증() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(4, 1)
				);
		Line line1 = Line.of(points);
		assertThat(line1.getArea()).isEqualTo(3);

		points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 2)
				);
		Line line2 = Line.of(points);
		assertThat(line2.getArea()).isEqualTo(1.414, offset(0.0099));
	}
}
