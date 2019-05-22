package coordinate.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Line {
    private final Set<Point> points;

    Line(Point p1, Point p2) {
        validatePoints(p1, p2);
        Set<Point> points = new HashSet<Point>() {{
            add(p1);
            add(p2);
        }};
        this.points = Collections.unmodifiableSet(points);
    }

    private void validatePoints(Point p1, Point p2) {
        if (p1.equals(p2)) {
            throw new IllegalArgumentException("두 점이 같은 라인은 생성이 불가합니다.");
        }
    }

    public double length() {
        Iterator iterator = points.iterator();
        Point point1 = (Point) iterator.next();
        Point point2 = (Point) iterator.next();
        return point1.getDistanceWith(point2);
    }

    public boolean orthogonalTo(Line line) {
        if (slope() == 0) {
            if (line.slope() == 1) {
                return true;
            }
        }
        if (line.slope() == 0) {
            if (slope() == 1) {
                return true;
            }
        }
        if (Double.compare(line.slope() * slope(), -1) == 0) {
            return true;
        }
        return false;
    }

    private double slope() {
        Iterator iterator = points.iterator();
        Point point1 = (Point) iterator.next();
        Point point2 = (Point) iterator.next();
        int x = (point1.getYValue() - point2.getYValue());
        int y = point1.getXValue() - point2.getXValue();
        if (y == 0) return 1;
        return x / y;
    }

}
