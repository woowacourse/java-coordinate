package coordinate.domain;

import java.util.List;

public class Triangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 3;

    public Triangle(List<Point> points) {
        super(points, VALID_LENGTH_OF_POINTS);
        validateTrianglePoints();
    }

    private void validateTrianglePoints() {
        if (area() == 0) {
            throw new IllegalThreadStateException("세 점이 한 직선상에 있습니다.");
        }
    }

    @Override
    public double area() {
        double area = 0;
        points.add(points.get(0));
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            area += (double) ((p1.getX() + p2.getX()) * (p1.getY() - p2.getY())) / 2;
        }
        points.remove(points.size() - 1);

        return Math.abs(area);
    }

    @Override
    public String toString() {
        return "삼각형의 넓이는 " + area();
    }
}
