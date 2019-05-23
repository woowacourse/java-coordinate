package coordinate.domain.Figure;

import coordinate.domain.point.PointGroup;

public class FigureFactory implements FigureCreator {
    @Override
    public Figure create(PointGroup points) {
        try {
            return figures.get(points.size()).apply(points);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("허용되지 않은 형태입니다. (라인, 삼각형, 직사각형 허용)");
        }
    }
}
