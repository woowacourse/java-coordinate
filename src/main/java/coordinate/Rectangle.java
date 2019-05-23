package coordinate;

import java.util.*;

public class Rectangle {
    private List<Point> points;
    public Rectangle(List<Point> points) {
        validateRectangle(points);
        this.points = points;
    }

    private void validateRectangle(List<Point> points) {
        if (!checkRectangle(points)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkRectangle(List<Point> points) {

        return  collectXValues(points).size() == 2 && collectYValues(points).size() == 2;
    }

    private Set<Value> collectXValues(List<Point> points) {
        Set<Value> xValues = new HashSet<>();
        for (Point point : points) {
            xValues.add(point.getXValue());
        }
        return xValues;
    }

    private Set<Value> collectYValues(List<Point> points) {
        Set<Value> yValues = new HashSet<>();
        for (Point point : points) {
            yValues.add(point.getYValue());
        }
        return yValues;
    }

    public double findArea(){
        List<Double> distances = new ArrayList<>();
        for (int i = 1; i < points.size(); i++) {
            distances.add(points.get(0).calculate(points.get(i)));
        }
        Collections.sort(distances);
        return distances.get(0) * distances.get(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
