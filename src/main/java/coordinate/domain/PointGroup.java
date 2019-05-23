package coordinate.domain;

import java.util.*;

public class PointGroup {
    private final List<Point> points;

    public PointGroup(List<Point> points) {
        this.points = points;
    }

    public int size() {
        return points.size();
    }

    public List<Double> getDistances() {
        final Set<Double> distances = new HashSet<>();
        points.forEach(x -> points.forEach(y -> distances.add(x.getSquareDistanceWith(y))));
        distances.remove(Double.valueOf(0));
        return Collections.unmodifiableList(new ArrayList<>(distances));
    }
}
