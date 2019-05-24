package coordinate.model;

import java.util.*;

public class Rectangle extends AbstractFigure{

    public Rectangle(List<Point> points) {
        super(points);
        validateRectangle(points);
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

    @Override
    public List<Point> getPoints() {
        return null;
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double area(){
        double firstLine = points.get(0).calculate(points.get(1));
        double secondLine = points.get(0).calculate(points.get(2));
        return firstLine * secondLine;
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
