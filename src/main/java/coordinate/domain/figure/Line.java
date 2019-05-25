package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

public class Line extends Figure {
    public static final int POINT_COUNT = 2;

    Line(PointGroup points) {
        super(points, POINT_COUNT);
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("라인은 두 점으로 구성하세요");
        }
    }

    @Override
    public double calculate() {
        return length();
    }

    private double length() {
        return Math.sqrt(getPoints().getSquaredDistanceOf(0, 1));
    }
}
