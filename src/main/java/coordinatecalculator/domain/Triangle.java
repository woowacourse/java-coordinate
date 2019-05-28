package coordinatecalculator.domain;

public class Triangle extends AbstractFigure {
    private static final String ERROR_THREE_POINTS_SAME_LINE = "입력한 좌표가 삼각형이 아닙니다.";
    private static final String TRIANGLE_NAME = "삼각형";
    private static final int HALF = 2;

    public Triangle(final PointGroup points) {
        super(points);
        checkValidTriangle();
    }

    private void checkValidTriangle() {
        if (isPointsSameLine()) {
            throw new IllegalArgumentException(ERROR_THREE_POINTS_SAME_LINE);
        }
    }

    private boolean isPointsSameLine() {
        double firstAngle = getAngle(FigureConstant.SECOND_POINT, FigureConstant.THIRD_POINT);
        double secondAngle = getAngle(FigureConstant.THIRD_POINT, FigureConstant.SECOND_POINT);

        return isZeroOrStraightAngle(firstAngle)
                || isZeroOrStraightAngle(secondAngle);
    }

    private double getAngle(int secondPoint, int thirdPoint) {
        return getPoint(FigureConstant.FIRST_POINT).getAngle(getPoint(secondPoint), getPoint(thirdPoint));
    }

    private boolean isZeroOrStraightAngle(final double angle) {
        return Double.compare(angle, FigureConstant.ZERO_ANGLE) == FigureConstant.SAME_ANGLE
                || Double.compare(angle, FigureConstant.STRAIGHT_ANGLE) == FigureConstant.SAME_ANGLE;
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
        double a = getPoint(FigureConstant.FIRST_POINT).getDistance(getPoint(FigureConstant.SECOND_POINT));
        double b = getPoint(FigureConstant.SECOND_POINT).getDistance(getPoint(FigureConstant.THIRD_POINT));
        double c = getPoint(FigureConstant.THIRD_POINT).getDistance(getPoint(FigureConstant.FIRST_POINT));
        double s = (a + b + c) / HALF;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getName() {
        return TRIANGLE_NAME;
    }
}
