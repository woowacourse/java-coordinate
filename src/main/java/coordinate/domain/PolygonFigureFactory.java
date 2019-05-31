package coordinate.domain;

import coordinate.Figure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolygonFigureFactory implements coordinate.FigureFactory {
    private static final Map<Integer, FigureCreator> FIGURE_CREATORS;

    static {
        FIGURE_CREATORS = new HashMap<>();
        FIGURE_CREATORS.put(Integer.valueOf(1), new NotFigureCreator());
        FIGURE_CREATORS.put(Integer.valueOf(2), new LineCreator());
        FIGURE_CREATORS.put(Integer.valueOf(3), new TriangleCreator());
        FIGURE_CREATORS.put(Integer.valueOf(4), new SquareCreator());
    }

    private PolygonFigureFactory() {
    }

    public static PolygonFigureFactory getInstance() {
        return SingleTon.SINGLETON_INSTANCE;
    }

    private static class SingleTon {
        private static final PolygonFigureFactory SINGLETON_INSTANCE = new PolygonFigureFactory();
    }

    @Override
    public Figure create(final List<Point> points) {
        try {
            return FIGURE_CREATORS.get(points.size()).create(points);
        } catch(NullPointerException e) {
            throw new IllegalArgumentException("올바른 개수의 좌표를 입력하세요");
        }
    }
}
