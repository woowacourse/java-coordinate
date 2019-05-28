package coordinate.domain;

import java.util.Arrays;
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
        Line lineA = Line.of(Arrays.asList(this.points.get(0), this.points.get(1)));
        Line lineB = Line.of(Arrays.asList(this.points.get(1), this.points.get(2)));
        Line lineC = Line.of(Arrays.asList(this.points.get(2), this.points.get(0)));

        Double semiParameter = (lineA.getArea() + lineB.getArea() + lineC.getArea()) / Double.valueOf(2.0);

        return Math.sqrt(semiParameter
                * (semiParameter - lineA.getArea())
                * (semiParameter - lineB.getArea()) * (semiParameter - lineC.getArea()));
    }

    @Override
    public String getName() {
        return "삼각형의 넓이";
    }
}
