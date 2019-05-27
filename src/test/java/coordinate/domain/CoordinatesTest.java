package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CoordinatesTest {

	@Test
	public void Coordinates클래스가가_직사각형을_제대로_생성하는지() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 2),
				Point.of(1, 2),
				Point.of(2, 1));
		Coordinates cb = new Coordinates(points);
		assertThat(cb.getAreaElement()).isEqualTo(1.0, offset(0.00099));
	}

	@Test
	public void Coordinates클래스가를_포인트_하나로_생성할때() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1)
		);
		Coordinates cb = new Coordinates(points);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			cb.getAreaElement();
		});
	}

	@Test
	public void Coordinates클래스가를_포인트_네개_이상으로로_생성할때() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 1),
				Point.of(3, 1),
				Point.of(2, 2),
				Point.of(3, 3)
		);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Coordinates(points);
		});
	}

	@Test
	public void Coordinates클래스가를_중복된_포인트로_생성할때() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 1),
				Point.of(1, 1)
		);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Coordinates(points);
		});
	}
}