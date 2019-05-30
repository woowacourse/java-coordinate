package coordinate.domain.figure;

import coordinate.domain.AbstractFigure;
import coordinate.domain.Point;

import java.util.List;

public class Triangle extends AbstractFigure {
    private Triangle(final List<Point> points) {
        super(points);
        if (isLine()) {
            throw new IllegalArgumentException("일직선입니다");
        }
    }

    public static Triangle of(List<Point> points) {
        return new Triangle(points);
    }

    private boolean isLine() {
        Double angleA = Double.valueOf(angle(FIRST, SECOND));
        Double angleB = Double.valueOf(angle(SECOND, THIRD));

        return (angleA.compareTo(angleB) == 0);
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
