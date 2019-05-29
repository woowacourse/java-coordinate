package coordinatecalculator.model;

import java.util.*;

public class Points {
    private static final int NEXT = 1;
    private static final int INPUT_MIN_SIZE = 2;
    private static final int INPUT_MAX_SIZE = 4;

    private List<Point> points;

    public Points(String[] inputPoint) {
        this.points = new ArrayList<>();
        createPoints(inputPoint);
    }

    private void createPoints(String[] inputPoint) {
        validateNumberOfPoint(inputPoint);
        for (String onePoint : inputPoint) {
            addPoint(new Point(onePoint));
        }
    }

    private void validateNumberOfPoint(String[] inputPoint) {
        if (inputPoint.length < INPUT_MIN_SIZE || inputPoint.length > INPUT_MAX_SIZE) {
            throw new IllegalArgumentException("입력 형식이 옳바르지 않습니다.");
        }
    }

    private void addPoint(Point point) {
        if (this.points.contains(point)) {
            throw new IllegalArgumentException("두점이 중복되었습니다.");
        }
        this.points.add(point);
    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getSize() {
        return points.size();
    }

    public double getGenerateDistance(int index) {
        Distance getDistance = generateDistances().get(index);

        return getDistance.getDistance();
    }

    private List<Distance> generateDistances() {
        List<Distance> distances = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            distances.add(this.getDistance(i, (i + NEXT) % points.size()));
        }

        return distances;
    }

    private Distance getDistance(int previousPointIndex, int currentPointIndex) {
        return new Distance(this.getPoint(previousPointIndex), this.getPoint(currentPointIndex));
    }

}
