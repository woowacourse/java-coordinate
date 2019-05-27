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
        Line a = Line.of(Arrays.asList(this.points.get(0), this.points.get(1)));
        Line b = Line.of(Arrays.asList(this.points.get(1), this.points.get(2)));
        Line c = Line.of(Arrays.asList(this.points.get(2), this.points.get(0)));

        Double s = (a.getArea() + b.getArea() + c.getArea()) / Double.valueOf(2.0);

        return Math.sqrt(s * (s - a.getArea()) * (s - b.getArea()) * (s - c.getArea()));
    }

    @Override
    public String getName() {
        return "삼각형의 넓이";
    }
}
