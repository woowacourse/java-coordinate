package coordinate.domain.Figure;

import coordinate.domain.point.PointGroup;

import java.util.Iterator;

public class Line extends Figure {
    private static final int POINT_COUNT = 2;

    Line(PointGroup points) {
        super(points, POINT_COUNT);
    }

    public double length() {
        Iterator iterator = getPoints().getSquaredDistances().iterator();
        return Math.sqrt((double) iterator.next());
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("라인은 두 점으로 구성하세요");
        }
    }
}
