package coordinate.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum FigureEnum {
    LINE(2, Line::new),
    TRIANGLE(3, Triangle::new),
    RECTANGLE(4, Rectangle::new);

    private int numOfPoint;
    private Function<Vertices, Figure> verticesFigureFunction;

    FigureEnum(int numOfPoint, Function<Vertices, Figure> verticesFigureFunction) {
        this.numOfPoint = numOfPoint;
        this.verticesFigureFunction = verticesFigureFunction;
    }

    public static Figure figureOf(Vertices vertices) {
        return Arrays.stream(values())
                .filter(value -> vertices.size() == value.numOfPoint)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("좌표의 개수는 2~4개만 가능합니다."))
                .verticesFigureFunction.apply(vertices);
    }
}
