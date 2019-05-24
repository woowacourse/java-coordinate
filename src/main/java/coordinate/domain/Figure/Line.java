package coordinate.domain.Figure;

import coordinate.domain.point.PointGroup;

public class Line extends Figure {
    private static final int POINT_COUNT = 2;

    Line(PointGroup points) {
        super(points, POINT_COUNT);
    }

    public double length() {
        return Math.sqrt(getPoints().getSquaredDistanceOf(0, 1));
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("라인은 두 점으로 구성하세요");
        }
    }
}
