package coordinate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

	@Test
	public void Point클래스가_제대로_생성되는지_테스트() {
		Point point = Point.of(Integer.valueOf(0), Integer.valueOf(2));
		assertThat(point.getX()).isEqualTo(0);
		assertThat(point.getY()).isEqualTo(2);

		assertThat(point).isEqualTo(Point.of(Integer.valueOf(0), Integer.valueOf(2)));
	}

	@Test
	public void test() {
		Point.of(0, 0);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			Point.of(Integer.valueOf(0), Integer.valueOf(-1));
			Point.of(Integer.valueOf(-1), Integer.valueOf(0));
			Point.of(Integer.valueOf(0), Integer.valueOf(25));
			Point.of(Integer.valueOf(25), Integer.valueOf(0));
		});
	}
}
