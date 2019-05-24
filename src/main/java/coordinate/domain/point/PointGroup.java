package coordinate.domain.point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointGroup {
    private final List<Point> points;

    public PointGroup(List<Point> points) {
        List<Point> orderedPoints = new ArrayList<>(points);
        Collections.sort(orderedPoints);
        this.points = Collections.unmodifiableList(orderedPoints);
    }

    public int size() {
        return points.size();
    }

    public double getSquaredDistanceOf(int i, int j) {
        return points.get(i).squaredDistanceFrom(points.get(j));
    }

    public boolean have(Point point) {
        return points.contains(point);
    }
}
