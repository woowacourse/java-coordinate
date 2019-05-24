package coordinate.domain.figure;

import coordinate.domain.nonefigure.PointGroup;

public abstract class Figure {
    private final PointGroup points;

    Figure(PointGroup points, int pointCount) {
        validation(points, pointCount);
        validatePoints(points);
        this.points = points;
    }

    private void validation(PointGroup points, int pointCount) {
        if (points == null) {
            throw new IllegalArgumentException("도형을 생성할 수 없습니다.");
        }
        if (points.size() != pointCount) {
            throw new IllegalArgumentException("점의 개수가 맞지 않습니다");
        }
    }

    abstract void validatePoints(PointGroup points);

    PointGroup getPoints() {
        return points;
    }
}
