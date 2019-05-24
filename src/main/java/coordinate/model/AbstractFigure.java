package coordinate.model;

import java.util.List;

public abstract class AbstractFigure implements Figure {
    protected final List<Point> points;

    public AbstractFigure(List<Point> points) {
        if (points.size() != size()) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 선분, 삼각형, 직사각형만 넣어주세요");
        }
        this.points = points;
    }

    protected Point getPoint(int index) {
        return points.get(index);
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }
}
