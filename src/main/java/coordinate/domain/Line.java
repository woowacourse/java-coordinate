package coordinate.domain;

import java.util.List;

public class Line extends AbstractFigure {
	private Line(final List<Point> points) {
		super(points);
	}

	static Line of(final List<Point> points) {
		return new Line(points);
	}

	public Double getArea() {
		return super.getDistance(0, 1);
	}

	@Override
	public String getName() {
		return "선의 길이";
	}
}