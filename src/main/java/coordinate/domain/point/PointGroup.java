package coordinate.domain.point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PointGroup {
    private final List<Point> points;

    public PointGroup(List<Point> points) {
        validatePoints(points);

        List<Point> sortedPoints = new ArrayList<>(points);
        Collections.sort(sortedPoints);
        this.points = Collections.unmodifiableList(sortedPoints);
    }

    private void validatePoints(List<Point> points) {
        if (points.size() > new HashSet(points).size()) {
            throw new IllegalArgumentException("위치가 같은 점(point)이 존재합니다. 세 점의 위치는 달라야 합니다.");
        }
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
