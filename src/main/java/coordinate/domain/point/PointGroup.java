package coordinate.domain.point;

import java.util.*;

public class PointGroup {
    private final Set<Point> points;

    public PointGroup(Set<Point> points) {
        this.points = Collections.unmodifiableSet(points);
    }

    public int size() {
        return points.size();
    }

    /*
    모든 점 간의 거리의 제곱 값을 Set으로 반환
     */
    public Set<Double> getSquaredDistances() {
        final Set<Double> distances = new HashSet<>();
        points.forEach(x -> points.forEach(y -> distances.add(x.squaredDistanceFrom(y))));
        distances.remove(Double.valueOf(0));
        return Collections.unmodifiableSet(distances);
    }

    /*
    점이 도형을 이룰 때, 이웃한 점 간의 거리의 제곱 값을 List로 반환
     */
    public List<Double> getSquaredLengths() {
        List<Point> orderedPoint = new ArrayList<>(points);
        Collections.sort(orderedPoint);
        List<Double> lengths = new ArrayList<>();
        for (int i = 0; i < orderedPoint.size(); i++) {
            lengths.add(orderedPoint.get(i).squaredDistanceFrom(orderedPoint.get((i + 1) % points.size())));
        }
        return lengths;
    }

    public boolean have(int x, int y) {
        return points.contains(Point.create(x, y));
    }
}
