package coordinate.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rectangle extends AbstractFigure {

    public Rectangle(List<Point> points) {
        super(points);
        validateRectangle(points);
    }

    private void validateRectangle(List<Point> points) {
        if (!checkRectangle(points)) {
            throw new IllegalArgumentException();
        }
    }

    //직사각형 검증 -> 고칠것
    private boolean checkRectangle(List<Point> points) {
        return collectXValues(points).size() == 2 && collectYValues(points).size() == 2;
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
    public int size() {
        return 4;
    }

    @Override
    public double area() {
        double firstLine = points.get(0).howFar(points.get(1));
        double secondLine = points.get(0).howFar(points.get(2));
        return firstLine * secondLine;
    }
}
