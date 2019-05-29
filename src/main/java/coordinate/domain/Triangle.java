package coordinate.domain;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Triangle extends AbstractFigure {
    private Triangle(Points points) {
        super(points);
    }

    public static Triangle from(Points points) {
        return new Triangle(points);
    }

    public double area() {
        // s == (len1 + len2 + len3) / 2
        double s = lengths().sum() / 2;

        // m == s * (s - len1) * (s - len2) * (s - len3)
        double m = lengths().reduce(s, (a, b) -> a * (s - b));

        return Math.sqrt(m);
    }

    private DoubleStream lengths() {
        int pointCnt = points.size();

        return IntStream
                .range(0, pointCnt)
                .mapToDouble(i -> points.distance(i, (i + 1) % pointCnt));
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    String getFigureName() {
        return "삼각형";
    }

    @Override
    String getMeasureUnitName() {
        return "넓이";
    }

    @Override
    double measure() {
        return area();
    }
}
