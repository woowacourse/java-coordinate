package coordinate.domain.figure;

import coordinate.domain.point.PointGroup;

public class Rectangle extends Figure implements AreaCalculable {
    private static final int POINT_COUNT = 4;

    public Rectangle(PointGroup points) {
        super(points, POINT_COUNT);
    }

    @Override
    public double area() {
        return Math.sqrt(getPoints().getSquaredDistanceOf(0, 1) * getPoints().getSquaredDistanceOf(0, 2));
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("직사각형은 4개의 점으로 이루어져야합니다.");
        }
        if (!checkRectangle(points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean checkRectangle(PointGroup points) {
        double side = points.getSquaredDistanceOf(0, 2);
        return checkPythagorean(points.getSquaredDistanceOf(3, 0), points.getSquaredDistanceOf(2, 3), side)
                && checkPythagorean(points.getSquaredDistanceOf(1, 2), points.getSquaredDistanceOf(0, 1), side);
    }

    private boolean checkPythagorean(double hypotenuseSquare, double side1, double side2) {
        return Double.compare(hypotenuseSquare, side1 + side2) == 0;
    }

    @Override
    public String toString() {
        return "사각형";
    }
}
