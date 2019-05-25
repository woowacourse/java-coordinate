package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.Arrays;
import java.util.function.Function;

public enum NumberOfPoints {
    LINE(2, Line::new),
    TRIANGLE(3, Triangle::new),
    RECTANGLE(4, Rectangle::new);

    private int countOfPoints;

    private Function<Points, Figure> figureFunction;

    NumberOfPoints(int countOfPoints, Function<Points, Figure> figureFunction) {
        this.countOfPoints = countOfPoints;
        this.figureFunction = figureFunction;
    }

    public static Figure selectFigure(Points points) {
        return Arrays.stream(values())
                .filter(n -> n.countOfPoints == points.getPointsSize())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("허용된 도형이 아닙니다. 다시 입력해주세요."))
                .figureFunction.apply(points);
    }
}
