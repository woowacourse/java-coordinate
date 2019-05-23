package coordinate.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum Shape {
    LINE(2, Line::new),
    TRIANGLE(3, Triangle::new),
    RECTANGLE(4, Rectangle::new);

    private int numberOfPoints;
    private Function<Points, Figure> create;

    Shape(int numberOfPoints, Function<Points, Figure> create) {
        this.numberOfPoints = numberOfPoints;
        this.create = create;
    }

    public static Figure createFigure(Points points) {
        return Arrays.stream(values())
                .filter(shape -> shape.match(points.size()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Shape 입니다."))
                .create.apply(points);
    }

    private boolean match(int pointsSize) {
        return this.numberOfPoints == pointsSize;
    }
}
