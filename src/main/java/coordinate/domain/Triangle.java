package coordinate.domain;

import java.util.List;

public class Triangle extends AbstractFigure {

    private Triangle(final List<Point> points) {
        super(points);
    }

    static Triangle of(List<Point> points) {
        return new Triangle(points);
    }

    @Override
    public Double getArea() {
        double lineA = getDistance(0, 1);
        double lineB = getDistance(1, 2);
        double lineC = getDistance(2, 0);

        Double semiParameter = (lineA + lineB + lineC) / Double.valueOf(2.0);

        return Math.sqrt(semiParameter
                * (semiParameter - lineA)
                * (semiParameter - lineB) * (semiParameter - lineC));
    }

    @Override
    public String getName() {
        return "삼각형의 넓이";
    }
}
