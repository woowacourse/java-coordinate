package coordinate.domain;

import coordinate.Figure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FigureFactoryTest {
	FigureFactory figureFactory;
	List<Point> points;

	@BeforeEach
	public void setUp() {
		figureFactory = FigureFactory.getInstance();
	}

	@Test
	public void 넓이가_1인_직사각형을_생성하고_넓이를_반환하는지() {
		points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 2),
				Point.of(1, 2),
				Point.of(2, 1));
		Figure figure = FigureFactory.getInstance().create(points);
		assertThat(figure.getArea()).isEqualTo(1.0, offset(0.00099));
	}

	@Test
	public void 넓이가_4인_직사각형을_생성하고_넓이를_반환하는지() {
		points = Arrays.asList(
				Point.of(22, 24),
				Point.of(24, 24),
				Point.of(22, 22),
				Point.of(24, 22));

		Figure figure = FigureFactory.getInstance().create(points);
		assertThat(figure.getArea()).isEqualTo(4.0, offset(0.0099));

	}

	@Test
	public void 넓이가_8인_직사각형_4X2_을_생성하고_넓이를_반환하는지() {
		points = Arrays.asList(
				Point.of(0, 0),
				Point.of(0, 2),
				Point.of(4, 2),
				Point.of(4, 0));

		Figure figure = FigureFactory.getInstance().create(points);
		assertThat(figure.getArea()).isEqualTo(8.0, offset(0.0099));
	}

	@Test
	public void 직사각형이_아닐때_예외를_발생시키는지() {
		points = Arrays.asList(
				Point.of(0, 0),
				Point.of(0, 2),
				Point.of(4, 2),
				Point.of(4, 1));

		Figure figure = FigureFactory.getInstance().create(points);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			assertThat(figure.getArea()).isEqualTo(8.0, offset(0.0099));
		});
	}

	@Test
	public void 삼각형을_생성하고_널이를_반환하는지() {
		points = Arrays.asList(
				Point.of(0, 0),
				Point.of(0, 3),
				Point.of(4, 0));
		Figure triangle = figureFactory.create(points);
		assertThat(triangle.getArea()).isEqualTo(6.0, offset(0.00099));
	}

	@Test
	public void 넓이가_6인_직각삼각형을_생성하고_넓이를_반환하는지() {
		points = Arrays.asList(
				Point.of(0, 0),
				Point.of(0, 3),
				Point.of(4, 0));
		Figure triangle = figureFactory.create(points);
		assertThat(triangle.getArea()).isEqualTo(6.0, offset(0.00099));
	}

	@Test
	public void 넓이가_2인_삼각형을_생성하고_넓이를_반환하는지() {
		points = Arrays.asList(
				Point.of(0, 0),
				Point.of(2, 0),
				Point.of(1, 2));
		Figure triangle = figureFactory.create(points);
		assertThat(triangle.getArea()).isEqualTo(2.0, offset(0.00099));
	}

	@Test
	public void NotFigure를_제대로_생성하고_넓이를_반환할때_예외가_발생하는지() {
		points = Arrays.asList(
				Point.of(1, 1)
		);
		Figure figure = FigureFactory.getInstance().create(points);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			figure.getArea();
		});
	}

	@Test
	public void 포인트_네개_초과일때_예외발생_하는지() {
		points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 1),
				Point.of(3, 1),
				Point.of(2, 2),
				Point.of(3, 3)
		);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			FigureFactory.getInstance().create(points);
		});
	}

	@Test
	public void 중복된_좌표일때_예외발생하는지() {
		points = Arrays.asList(
				Point.of(1, 1),
				Point.of(2, 1),
				Point.of(1, 1)
		);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			FigureFactory.getInstance().create(points);
		});
	}
}