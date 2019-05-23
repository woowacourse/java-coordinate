package coordinate.domain.point;

import java.util.*;

public class PointGroup {
    private final List<Point> points;

    public PointGroup(List<Point> points) {
        this.points = points;
    }

    public int size() {
        return points.size();
    }

    public Set<Double> getSquareDistances() {
        final Set<Double> distances = new HashSet<>();
        points.forEach(x -> points.forEach(y -> distances.add(x.getSquareDistanceWith(y))));
        distances.remove(Double.valueOf(0));
        return Collections.unmodifiableSet(distances);
    }

    public List<Double> getTriagleSquareDistances() {
        List<Double> distances = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            distances.add(points.get(i).getSquareDistanceWith(points.get((i + 1) % points.size())));
        }
        return distances;
    }

    public boolean have(int x, int y) {
        return points.contains(Point.create(x,y));
    }
}
