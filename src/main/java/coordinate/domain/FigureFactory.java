package coordinate.domain;

import coordinate.Factory;
import coordinate.Figure;
import coordinate.domain.creator.LineCreator;
import coordinate.domain.creator.NotFigureCreator;
import coordinate.domain.creator.SquareCreator;
import coordinate.domain.creator.TriangleCreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory implements Factory {
    private static final Map<Integer, FigureCreator> FIGURE_CREATORS;

    static {
        FIGURE_CREATORS = new HashMap<>();
        FIGURE_CREATORS.put(Integer.valueOf(1), new NotFigureCreator());
        FIGURE_CREATORS.put(Integer.valueOf(2), new LineCreator());
        FIGURE_CREATORS.put(Integer.valueOf(3), new TriangleCreator());
        FIGURE_CREATORS.put(Integer.valueOf(4), new SquareCreator());
    }

    private FigureFactory() {
    }

    public static FigureFactory getInstance() {
        return SingleTon.SINGLETON_INSTANCE;
    }

    private static class SingleTon {
        static final FigureFactory SINGLETON_INSTANCE = new FigureFactory();
    }

    @Override
    public Figure create(final List<Point> points) {
        try {
            return FIGURE_CREATORS.get(points.size()).create(points);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("5개 미만의 좌표를 입력하세요");
        }
    }
}
