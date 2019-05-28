package coordinatecalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static coordinatecalculator.FigureType.*;

enum FigureType { // 굳이 이렇게 할 필요는 없지만, enum 수업을 들었으니 연습삼아.
    POINT(1),
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private final int pointsCount;

    FigureType(int pointsCount) {
        this.pointsCount = pointsCount;
    }

    static FigureType valueOf(int pointsCount) throws IllegalArgumentException {
        for (FigureType value : values()) {
            if (value.pointsCount == pointsCount) {
                return value;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}

class FigureFactory {
    private static final Map<FigureType, Function<List<Point>, Figure>> creators;

    static {
        creators = new HashMap<>();
        creators.put(POINT, Point::new);
        creators.put(LINE, Line::new);
        creators.put(TRIANGLE, Triangle::new);
        creators.put(RECTANGLE, Rectangle::new);
    }

    static Figure of(List<Point> points) {
        final FigureType type = FigureType.valueOf(points.size());
        return creators.get(type).apply(points);
    }
}