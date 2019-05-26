package coordinate.domain;

import coordinate.AbstractFigure;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Square extends AbstractFigure {

	private Square(final List<Point> points) {
		super(points);
	}

	public static Square of(final List<Point> points) {
		return new Square(points);
	}

	@Override
	public Double getArea() {
		Point origin = this.points.get(0);
		Line verticalLine = Line.of(Arrays.asList(origin, getSameX(origin)));
		Line horizontalLine = Line.of(Arrays.asList(origin, getSameY(origin)));
		return (verticalLine.getArea() * horizontalLine.getArea());
	}

	private Point getSameX(final Point origin) {
		Optional<Point> optPoint = points.subList(1, points.size()).stream()
				.filter(origin::isSameX)
				.findFirst();

		return optPoint.orElseThrow(() -> new IllegalArgumentException("점이 네개지만 직사각형이 아닙니다"));
	}

	private Point getSameY(final Point origin) {
		Optional<Point> optPoint = points.subList(1, points.size()).stream()
				.filter(origin::isSameY)
				.findFirst();

		return optPoint.orElseThrow(() -> new IllegalArgumentException("점이 네개지만 직사각형이 아닙니다"));
	}

	@Override
	public String getName() {
		return "직사각형의 넓이";
	}
}
