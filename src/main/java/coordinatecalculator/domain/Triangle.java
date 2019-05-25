package coordinatecalculator.domain;

import java.util.List;

public class Triangle extends Figure {
    private static final String THREE_POINTS_SAME_LINE = "입력한 좌표가 삼각형이 아닙니다.";
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int THIRD_POINT = 2;
    private static final int SAME_ANGLE = 0;
    private static final int STRAIGHT_ANGLE = 180;
    private static final int ZERO_ANGLE = 0;

    public Triangle(List<Point> points) {
        super(points);
        checkValidTriangle();
    }

    private void checkValidTriangle() {
        if (isPointsSameLine()) {
            throw new IllegalArgumentException(THREE_POINTS_SAME_LINE);
        }
    }

    private boolean isPointsSameLine() {
        double firstAngle = getPoint(FIRST_POINT).getAngle(getPoint(SECOND_POINT), getPoint(THIRD_POINT));
        double secondAngle = getPoint(FIRST_POINT).getAngle(getPoint(THIRD_POINT), getPoint(SECOND_POINT));

        return isZeroOrStraightAngle(firstAngle)
                || isZeroOrStraightAngle(secondAngle);
    }

    private boolean isZeroOrStraightAngle(double angle) {
        return Double.compare(angle, ZERO_ANGLE) == SAME_ANGLE
                || Double.compare(angle, STRAIGHT_ANGLE) == SAME_ANGLE;
    }

    /**
     * 'heronFormula'
     * area = sqrt(s*(s-a)(s-b)(s-c))
     * s = (a + b + c) / 2
     *
     * @return area
     */
    @Override
    public double area() {
        double a = getPoint(FIRST_POINT).getDistance(getPoint(SECOND_POINT));
        double b = getPoint(SECOND_POINT).getDistance(getPoint(THIRD_POINT));
        double c = getPoint(THIRD_POINT).getDistance(getPoint(FIRST_POINT));
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
