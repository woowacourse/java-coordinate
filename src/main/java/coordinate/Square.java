package coordinate;

import java.util.*;

public class Square {
    private final List<Point> points;

    public Square(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) throws IllegalArgumentException {
        Set temp = new HashSet<>(points);
        if (temp.size() != points.size()) {
            throw new IllegalArgumentException("직사각형을 만들 수 없습니다");
        }
    }

    public Double getArea() {
        Point origin = points.get(0);
        Line line1 = Line.of(Arrays.asList(origin, getSameX(origin)));
        Line line2 = Line.of(Arrays.asList(origin, getSameY(origin)));
        return (line1.length() * line2.length());
    }

    private Point getSameX(final Point origin) {
        Optional<Point> optPoint = points.subList(1, points.size()).stream()
                .filter(origin::isSameX)
                .findFirst();

        return optPoint.orElseThrow(IllegalArgumentException::new);
    }

    private Point getSameY(final Point origin) {
        Optional<Point> optPoint = points.subList(1, points.size()).stream()
                .filter(origin::isSameY)
                .findFirst();

        return optPoint.orElseThrow(IllegalArgumentException::new);
    }
}
