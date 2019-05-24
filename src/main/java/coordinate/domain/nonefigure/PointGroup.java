package coordinate.domain.nonefigure;

import java.util.*;

public class PointGroup {
    private final List<Point> points;

    public PointGroup(List<Point> points) {
        this.points = points;
    }


    public List<Double> getDistances() {
        List<Double> distances = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            distances.add(points.get(i).getSquareDistanceWith(points.get((i + 1) % points.size())));
        }
        return distances;
    }

    public boolean have(int x, int y) {
        return points.contains(Point.create(x,y));
    }

    public int size() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
