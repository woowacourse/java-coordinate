package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final String ERROR_INVALID_FIGURE_CREATION = "입력된 Point 개수가 유효하지 않습니다.";
    private static final int NUM_OF_VERTICES_OF_LINE = 2;
    private static final int NUM_OF_VERTICES_OF_TRIANGLE = 3;
    private static final int NUM_OF_VERTICES_OF_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>, Figure>> classifier = new HashMap<>();

    static {
        classifier.put(NUM_OF_VERTICES_OF_LINE, Line::new);
        classifier.put(NUM_OF_VERTICES_OF_TRIANGLE, Triangle::new);
        classifier.put(NUM_OF_VERTICES_OF_RECTANGLE, Rectangle::new);
    }

    public static Figure create(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException(AbstractFigure.ERROR_FIGURE_NULL);
        }
        if (isInvalidNumberOf(points)) {
            throw new IllegalArgumentException(ERROR_INVALID_FIGURE_CREATION);
        }
        return classifyFigure(points);
    }

    private static boolean isInvalidNumberOf(List<Point> points) {
        int numOfPoints = points.size();
        return numOfPoints < NUM_OF_VERTICES_OF_LINE || numOfPoints > NUM_OF_VERTICES_OF_RECTANGLE;
    }

    private static Figure classifyFigure(List<Point> points) {
        return classifier.get(points.size()).apply(points);
    }
}
