package coordinatecalculator.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory implements FigureCreator {
    private static final int LINE_SIZE = 2;
    private static final int TRIANGLE_SIZE = 3;
    private static final int RECTANGLE_SIZE = 4;
    private static final String ERROR_INSUFFICIENT_POINTS = "입력한 좌표의 개수는 '선', '삼각형', '직사각형'을 만들 수 없습니다.";

    private Map<Integer, Function<List<Point>, Figure>> figures;

    public FigureFactory() {
        figures = new HashMap<>();
        figures.put(LINE_SIZE, Line::new);
        figures.put(TRIANGLE_SIZE, Triangle::new);
        figures.put(RECTANGLE_SIZE, Rectangle::new);
    }

    @Override
    public Figure create(final List<Point> points) {
        try {
            return figures.get(points.size()).apply(points);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException(ERROR_INSUFFICIENT_POINTS);
        }
    }
}
