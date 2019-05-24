package coordinatecalculator;

import java.util.Collections;
import java.util.List;

public class Rectangle implements Figure {
    private static final String NOT_RECTANGLE_COORDINATE = "입력한 좌표가 직사각형이 아닙니다.";
    private static final int LEFT_BOTTOM = 0;
    private static final int LEFT_TOP = 1;
    private static final int RIGHT_BOTTOM = 2;
    private static final int RIGHT_TOP = 3;
    private static final int RIGHT_ANGLE = 90;
    private static final int DIFFERENT_VALUE = 1;

    private List<Point> points;

    public Rectangle(List<Point> points) {
        this.points = points;
        checkValidRectangle();
    }

    private void checkValidRectangle() {
        sortPoints();

        if (hasNonOrthogonal()) {
            throw new IllegalArgumentException(NOT_RECTANGLE_COORDINATE);
        }
    }

    private void sortPoints() {
        Collections.sort(points);
    }

    private boolean hasNonOrthogonal() {
        double firstAngle = getAngle(LEFT_BOTTOM, LEFT_TOP, RIGHT_BOTTOM);
        double secondAngle = getAngle(LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM);
        double thirdAngle = getAngle(RIGHT_BOTTOM, RIGHT_TOP, LEFT_BOTTOM);
        double fourthAngle = getAngle(RIGHT_TOP, LEFT_TOP, RIGHT_BOTTOM);

        return isNonOrthogonal(firstAngle)
                || isNonOrthogonal(secondAngle)
                || isNonOrthogonal(thirdAngle)
                || isNonOrthogonal(fourthAngle);
    }

    private double getAngle(int firstPoint, int secondPoint, int thirdPoint) {
        return getPoint(firstPoint).getAngle(getPoint(secondPoint), getPoint(thirdPoint));
    }

    private Point getPoint(int index) {
        return points.get(index);
    }

    private boolean isNonOrthogonal(double angle) {
        return Double.compare(angle, RIGHT_ANGLE) == DIFFERENT_VALUE;
    }

    @Override
    public double area() {
        double height = getPoint(LEFT_BOTTOM).getDistance(getPoint(LEFT_TOP));
        double width = getPoint(LEFT_BOTTOM).getDistance(getPoint(RIGHT_BOTTOM));

        return height * width;
    }
}
