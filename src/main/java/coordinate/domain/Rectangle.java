package coordinate.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rectangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 4;
    private static final int ALLOWED_NUMBER_OF_POINTS_FOR_AXIS = 2;

    public Rectangle(List<Point> points) {
        super(points, VALID_LENGTH_OF_POINTS);
        validateRectanglePoints();
    }

    private void validateRectanglePoints() {
        Set<Integer> projectedXAxis = getProjectedXAxis();
        Set<Integer> projectedYAxis = getProjectedYAxis();
        if (projectedXAxis.size() != ALLOWED_NUMBER_OF_POINTS_FOR_AXIS || projectedYAxis.size() != ALLOWED_NUMBER_OF_POINTS_FOR_AXIS) {
            throw new IllegalArgumentException("직사각형의 좌표를 입력해 주세요.");
        }
    }

    private Set<Integer> getProjectedXAxis() {
        Set<Integer> projectedXAxis = new HashSet<>();
        for (Point point : points) {
            projectedXAxis.add(point.getX());
        }
        return projectedXAxis;
    }

    private Set<Integer> getProjectedYAxis() {
        Set<Integer> projectedYAxis = new HashSet<>();
        for (Point point : points) {
            projectedYAxis.add(point.getY());
        }
        return projectedYAxis;
    }

    @Override
    public double area() {
        List<Integer> projectedXAxis = new ArrayList<>(getProjectedXAxis());
        List<Integer> projectedYAxis = new ArrayList<>(getProjectedYAxis());

        int width = Math.abs(projectedXAxis.get(0) - projectedXAxis.get(1));
        int height = Math.abs(projectedYAxis.get(0) - projectedYAxis.get(1));
        double area = width * height;

        return area;
    }

    @Override
    public String toString() {
        return "사각형의 넓이는 " + area();
    }
}
