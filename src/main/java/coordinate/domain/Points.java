package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public int size() {
        return points.size();
    }

    public List<Double> getAllDistances() {
        List<Double> distances = new ArrayList<>();
        for (Integer distanceSquare : getAllDistanceSquares()) {
            distances.add(Math.sqrt(distanceSquare));
        }
        return distances;
    }

    public List<Integer> getAllDistanceSquares() {
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            getDistanceSquare(distances, i);
        }
        return distances;
    }

    private void getDistanceSquare(List<Integer> distances, int i) {
        Point point = points.get(i);
        for (int j = i + 1; j < points.size(); j++) {
            Point otherPoint = points.get(j);
            distances.add(point.distanceSquare(otherPoint));
        }
    }
}
