package coordinate.domain;

import java.util.List;

public class FigureFactory {
    public static Figure createFigure(Points points) {
        if (points.size() == 2) {
            return Line.from(points);
        }
        if (points.size() == 3) {

            return Triangle.from(points);
        }
        if (points.size() == 4) {
            return Rectangle.from(points);
        }

        throw new IllegalArgumentException("현재는 지원하지 않는 입력입니다.");
    }
}

