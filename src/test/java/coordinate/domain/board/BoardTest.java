package coordinate.domain.board;

import coordinate.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

	@Test
	public void Board클래스가_직사각형을_제대로_생성하는지() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 2),
				Point.of(1, 2),
				Point.of(2, 1));
		CoordinateBoard cb = new CoordinateBoard(points);
		assertThat(cb.getPoints()).isEqualTo(points);
		assertThat(cb.getAreaElement()).isEqualTo(1.0, offset(0.00099));
	}

	@Test
	public void Board클래스를_포인트_하나로_생성할때() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1)
		);
		CoordinateBoard cb = new CoordinateBoard(points);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			cb.getAreaElement();
		});
	}

	@Test
	public void Board클래스를_포인트_네개_이상으로로_생성할때() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 1),
				Point.of(3, 1),
				Point.of(2, 2),
				Point.of(3, 3)
		);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			CoordinateBoard cb = new CoordinateBoard(points);
		});
	}

	@Test
	public void Board클래스를_중복된_포인트로_생성할때() {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 1),
				Point.of(1, 1)
		);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			CoordinateBoard cb = new CoordinateBoard(points);
		});
	}
}