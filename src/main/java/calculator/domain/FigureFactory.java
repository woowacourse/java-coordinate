package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class FigureFactory {
    private static final int POINT_CONDITION = 1;
    private static final int LINE_CONDITION = 2;
    private static final int TRIANGLE_CONDITION = 3;
    private static final int RECTANGLE_CONDITION = 4;
    private static final String EX_NO_FIGURE_CONDITION_MESSAGE = "만들 수 있는 도형이 없습니다. (가능한 도형은 점, 선, 삼각형, 사각형입니다.)";

    private static final Map<Integer, Function<Coordinates, Figure>> figureCreate;

    static {
        figureCreate = new HashMap<>();
        figureCreate.put(POINT_CONDITION, Point::new);
        figureCreate.put(LINE_CONDITION, Line::new);
        figureCreate.put(TRIANGLE_CONDITION, Triangle::new);
        figureCreate.put(RECTANGLE_CONDITION, Rectangle::new);
    }

    public Figure create(Coordinates coordinates) {
        if (figureCreate.get(coordinates.size()) == null) {
            throw new IllegalArgumentException(EX_NO_FIGURE_CONDITION_MESSAGE);
        }

        return figureCreate.get(coordinates.size()).apply(coordinates);
    }
}
