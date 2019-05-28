package coordinate.domain.figure;

import coordinate.domain.AbstractFigure;
import coordinate.domain.Point;

import java.util.List;

public class Triangle extends AbstractFigure {
    private Triangle(final List<Point> points) {
        super(points);
    }

    public static Triangle of(List<Point> points) {
        return new Triangle(points);
    }

    @Override
    public double getArea() {
        double lineA = super.getDistance(FIRST, SECOND);
        double lineB = super.getDistance(SECOND, THIRD);
        double lineC = super.getDistance(THIRD, FIRST);

        double semiParameter = (lineA + lineB + lineC) / Double.valueOf(2.0);

        return Math.sqrt(semiParameter
                * (semiParameter - lineA)
                * (semiParameter - lineB) * (semiParameter - lineC));
    }

    @Override
    public String getName() {
        return "삼각형의 넓이";
    }
}
