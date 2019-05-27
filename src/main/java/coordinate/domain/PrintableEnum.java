package coordinate.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public enum PrintableEnum {

    LINE(2, Line::create),
    TRIANGLE(3, Triangle::create),
    RECTANGLE(4, Rectangle::create);

    private final int size;
    private final Function<Points, ResultPrintable> creator;

    PrintableEnum(int size, Function<Points, ResultPrintable> creator) {
        this.size = size;
        this.creator = creator;
    }

    public static PrintableEnum valueOf(int size) {
        Optional<PrintableEnum> optional = Arrays.stream(PrintableEnum.values())
                .filter(value -> value.size == size)
                .findFirst();

        return optional.orElse(null);
    }

    public ResultPrintable create(Points points) {
        return creator.apply(points);
    }
}
