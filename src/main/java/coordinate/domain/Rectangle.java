package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Rectangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 4;
    private static final int ALLOWED_NUMBER_OF_POINTS_FOR_AXIS = 2;

    Rectangle(Points points) {
        super(points, VALID_LENGTH_OF_POINTS);
        validateRectanglePoints();
    }

    private void validateRectanglePoints() {
        Set<Integer> projectedXAxis = points.getProjectedXAxis();
        Set<Integer> projectedYAxis = points.getProjectedYAxis();
        if (projectedXAxis.size() != ALLOWED_NUMBER_OF_POINTS_FOR_AXIS || projectedYAxis.size() != ALLOWED_NUMBER_OF_POINTS_FOR_AXIS) {
            throw new IllegalArgumentException("직사각형의 좌표를 입력해 주세요.");
        }
    }

    @Override
    public double area() {
        List<Integer> projectedXAxis = new ArrayList<>(points.getProjectedXAxis());
        List<Integer> projectedYAxis = new ArrayList<>(points.getProjectedYAxis());

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
