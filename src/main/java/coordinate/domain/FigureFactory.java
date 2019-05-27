package coordinate.domain;

import java.util.HashMap;
import java.util.Map;

public class FigureFactory {

    private static Map<Integer, FigureCreator> creators = initCreators();

    private static Map<Integer, FigureCreator> initCreators() {
        Map<Integer, FigureCreator> creators = new HashMap<>();

        creators.put(2, Line::from);
        creators.put(3, Triangle::from);
        creators.put(4, Rectangle::from);

        return creators;
    }

    public static Figure createFigure(Points points) {
        if (creators.containsKey(points.size())) {
            return creators.get(points.size()).create(points);
        }

        throw new IllegalArgumentException("현재는 지원하지 않는 입력입니다.");
    }
}

