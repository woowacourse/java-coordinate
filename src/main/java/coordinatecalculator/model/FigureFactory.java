package coordinatecalculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory implements FigureCreator{
    private static final int LINE_SIZE = 2;
    private static final int TRIANGLE_SIZE = 3;
    private static final int RECTANGLE_SIZE = 4;
    private static final Map<Integer, Function<Points, Figure>> figureFactory;

    static {
        figureFactory = new HashMap<>();
        figureFactory.put(LINE_SIZE, Line::new);
        figureFactory.put(TRIANGLE_SIZE, Triangle::new);
        figureFactory.put(RECTANGLE_SIZE, Rectangle::new);
    }

    @Override
    public Figure create(Points points) {
        if (!figureFactory.containsKey(points.getSize())) {
            throw new IllegalArgumentException("잘못된 점의 개수 입니다.");
        }
        return figureFactory.get(points.getSize()).apply(points);
    }
}
