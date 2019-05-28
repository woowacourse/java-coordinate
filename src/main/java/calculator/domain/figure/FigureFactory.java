package calculator.domain.figure;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author soojinroh
 * @version 1.0 2019-05-22
 */
public class FigureFactory {
    private static final String EX_NO_SUCH_FIGURE_MESSAGE = "4각형까지만 지원되는 프로그램입니다.";
    private static final int LINE = 2;
    private static final int TRIANGLE = 3;
    private static final int RECTANGLE = 4;

    private static final Map<Integer, Function<Coordinates, Figure>> figures = new HashMap<>();

    static {
        figures.put(LINE, Line::new);
        figures.put(TRIANGLE, Triangle::new);
        figures.put(RECTANGLE, Rectangle::new);
    }

    public static Figure create(Coordinates coordinates) {
        if (figures.get(coordinates.size()) == null) {
            throw new IllegalArgumentException(EX_NO_SUCH_FIGURE_MESSAGE);
        }

        return figures.get(coordinates.size()).apply(coordinates);
    }
}