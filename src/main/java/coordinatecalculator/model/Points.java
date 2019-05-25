package coordinatecalculator.model;


import java.util.*;

public class Points {

    private static final int LINE_SIZE = 2;
    private static final int RECTANGLE_SIZE = 4;
    private List<Point> points;

    public Points(String[] scannedPoints) {
        if (scannedPoints.length < LINE_SIZE || scannedPoints.length > RECTANGLE_SIZE) {
            throw new IllegalArgumentException("잘못된 점 개수 입니다.");
        }
        this.points = new ArrayList<>();
        for (String scannedPoint : scannedPoints) {
            this.addPoint(new Point(scannedPoint));
        }
    }

    private void addPoint(Point point) {
        if (this.points.contains(point)) {
            throw new IllegalArgumentException("중복된 점이 있습니다.");
        }
        this.points.add(point);
    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public int getSize() {
        return this.points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Distance> generateDistances() {
        List<Distance> distances = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            distances.add(this.getDistance(i, (i + 1) % points.size()));
        }
        return distances;
    }

    public Distance getDistance(int previousPointIndex, int currentPointIndex) {
        return new Distance(this.getPoint(previousPointIndex), this.getPoint(currentPointIndex));
    }
}
