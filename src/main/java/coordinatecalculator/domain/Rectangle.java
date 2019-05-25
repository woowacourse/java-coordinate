package coordinatecalculator.domain;

import java.util.List;

public class Rectangle extends Shape {
    private static final String NOT_RECTANGLE_COORDINATE = "입력한 좌표가 직사각형이 아닙니다.";
    private static final int LEFT_BOTTOM = 0;
    private static final int LEFT_TOP = 1;
    private static final int RIGHT_BOTTOM = 2;
    private static final int RIGHT_TOP = 3;
    private static final int RIGHT_ANGLE = 90;
    private static final int SAME_VALUE = 0;

    public Rectangle(List<Point> points) {
        super(points);
        checkValidRectangle();
    }

    private void checkValidRectangle() {
        sortPoints();

        if (hasNonOrthogonal()) {
            throw new IllegalArgumentException(NOT_RECTANGLE_COORDINATE);
        }
    }

    private boolean hasNonOrthogonal() {
        double firstAngle = getAngle(LEFT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM);
        double secondAngle = getAngle(RIGHT_TOP, LEFT_TOP, LEFT_BOTTOM);
        double thirdAngle = getAngle(RIGHT_TOP, RIGHT_BOTTOM, LEFT_BOTTOM);
        double fourthAngle = getAngle(LEFT_TOP, RIGHT_TOP, RIGHT_BOTTOM);

        return isNonOrthogonal(firstAngle)
                || isNonOrthogonal(secondAngle)
                || isNonOrthogonal(thirdAngle)
                || isNonOrthogonal(fourthAngle);
    }

    private double getAngle(int firstPoint, int secondPoint, int thirdPoint) {
        return getPoint(firstPoint).getAngle(getPoint(secondPoint), getPoint(thirdPoint));
    }

    private boolean isNonOrthogonal(double angle) {
        return Double.compare(Math.round(angle), RIGHT_ANGLE) != SAME_VALUE;
    }

    @Override
    public double area() {
        double height = getPoint(LEFT_BOTTOM).getDistance(getPoint(LEFT_TOP));
        double width = getPoint(LEFT_BOTTOM).getDistance(getPoint(RIGHT_BOTTOM));

        return height * width;
    }
}
