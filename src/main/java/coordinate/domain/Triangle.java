package coordinate.domain;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Triangle implements Figure{
    private final Points points;

    private Triangle(Points points) {
        this.points = points;
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

        return IntStream.range(0, pointCnt).mapToDouble(i -> {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % pointCnt);
            Vector2 v = p1.subtract(p2);

            return v.length();
        });
    }

    @Override
    public Points getPoints() {
        return points;
    }
}
