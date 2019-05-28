package coordinate.domain.figure;

import coordinate.domain.AbstractFigure;
import coordinate.domain.Point;

import java.util.List;

public class Line extends AbstractFigure {
	private Line(final List<Point> points) {
		super(points);
	}

	public static Line of(final List<Point> points) {
		return new Line(points);
	}

	public Double getArea() {
		return super.getDistance(FIRST, SECOND);
	}

	@Override
	public String getName() {
		return "선의 길이";
	}
}