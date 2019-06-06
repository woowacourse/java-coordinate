package coordinate.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public enum FigureEnum {

    LINE(2, Line::create),
    TRIANGLE(3, Triangle::create),
    RECTANGLE(4, Rectangle::create);

    private final int size;
    private final Function<Points, ResultPrintable> creator;

    FigureEnum(int size, Function<Points, ResultPrintable> creator) {
        this.size = size;
        this.creator = creator;
    }

    public static FigureEnum valueOf(int size) {
        Optional<FigureEnum> optional = Arrays.stream(FigureEnum.values())
                .filter(value -> value.size == size)
                .findFirst();

        return optional.orElseThrow(IllegalArgumentException::new);
    }

    public ResultPrintable create(Points points) {
        return creator.apply(points);
    }
}
