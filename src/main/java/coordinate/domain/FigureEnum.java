package coordinate.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum FigureEnum {
    LINE(2, Line::new),
    TRIANGLE(3, Triangle::new),
    RECTANGLE(4, Rectangle::new);

    int size;
    Function<Points, Figure> figureCreator;

    FigureEnum(int size, Function<Points, Figure> figureCreator) {
        this.size = size;
        this.figureCreator = figureCreator;
    }

    Figure valueOf(Points points) {
        return Arrays.stream(values())
                .filter(figureEnum -> points.size() == figureEnum.size)
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .figureCreator.apply(points);
    }
}
