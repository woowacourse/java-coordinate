package coordinate.domain.figure;

import coordinate.domain.AbstractFigure;
import coordinate.domain.Point;

import java.util.List;

public class Square extends AbstractFigure {

	private Square(final List<Point> points) {
		super(points);
	}

	public static Square of(final List<Point> points) {
		return new Square(points);
	}

	@Override
	public double getArea() {
		return (super.getMinVerticalDistance(FIRST) * super.getMinHorizontalDistance(FIRST));
	}

	@Override
	public String getName() {
		return "직사각형의 넓이";
	}
}
