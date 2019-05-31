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
		try {
			return (super.getMinVerticalDistance(FIRST) * super.getMinHorizontalDistance(FIRST));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("직사각형이 아닙니다. 넓이를 구하지 못합니다");
		}
	}

	@Override
	public String getName() {
		return "직사각형의 넓이";
	}
}
