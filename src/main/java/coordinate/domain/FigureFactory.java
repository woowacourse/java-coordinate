package coordinate.domain;

import java.util.HashMap;
import java.util.Map;

public class FigureFactory {

    private static Map<Integer, FigureCreator> creators;

    static {
        creators = new HashMap<>();

        creators.put(2, Line::from);
        creators.put(3, Triangle::from);
        creators.put(4, Rectangle::from);
    }

    public static Figure createFigure(Points points) {
        if (creators.containsKey(points.size())) {
            return creators.get(points.size()).create(points);
        }

        throw new NotSupportedFigureException("현재는 지원하지 않는 입력입니다.");
    }

    public static class NotSupportedFigureException extends RuntimeException {
        public NotSupportedFigureException(String message) {
            super(message);
        }
    }
}

