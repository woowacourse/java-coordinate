package coordinate.domain;

import java.util.List;

public class Line extends AbstractFigure {
	private static final int POW_NUM = 2;

	private Line(final List<Point> points) {
		super(points);
	}

	public static Line of(final List<Point> points) {
		return new Line(points);
	}

	public Double getArea() {
		final Double tempX = points.get(0).getX().doubleValue() - points.get(1).getX().doubleValue();
		final Double tempY = points.get(0).getY().doubleValue() - points.get(1).getY().doubleValue();

		return Math.sqrt(Math.pow(tempX, POW_NUM) + Math.pow(tempY, POW_NUM));
	}

	@Override
	public String getName() {
		return "선의 길이";
	}
}