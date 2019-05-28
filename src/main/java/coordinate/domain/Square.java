package coordinate.domain;

import java.util.List;

public class Square extends AbstractFigure {

	private Square(final List<Point> points) {
		super(points);
	}

	static Square of(final List<Point> points) {
		return new Square(points);
	}

	@Override
	public Double getArea() {
		int origin = 0;
		return (sameX(origin) * sameY(origin));
	}

	@Override
	public String getName() {
		return "직사각형의 넓이";
	}
}
