package coordinatecalculator.domain;

public class Triangle implements Figure {
    private static final String ERROR_THREE_POINTS_SAME_LINE = "입력한 좌표가 삼각형이 아닙니다.";
    private static final String TRIANGLE_NAME = "삼각형";
    private static final int HALF = 2;

    private PointGroup pointGroup;

    public Triangle(final PointGroup pointGroup) {
        this.pointGroup = pointGroup;
        checkValidTriangle();
    }

    private void checkValidTriangle() {
        if (isPointsSameLine()) {
            throw new IllegalArgumentException(ERROR_THREE_POINTS_SAME_LINE);
        }
    }

    private boolean isPointsSameLine() {
        double firstAngle = pointGroup.getAngle(FigureConstant.FIRST_POINT, FigureConstant.SECOND_POINT, FigureConstant.THIRD_POINT);
        double secondAngle = pointGroup.getAngle(FigureConstant.FIRST_POINT, FigureConstant.THIRD_POINT, FigureConstant.SECOND_POINT);

        return isZeroOrStraightAngle(firstAngle)
                || isZeroOrStraightAngle(secondAngle);
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
        double a = pointGroup.getLength(FigureConstant.FIRST_POINT, FigureConstant.SECOND_POINT);
        double b = pointGroup.getLength(FigureConstant.SECOND_POINT, FigureConstant.THIRD_POINT);
        double c = pointGroup.getLength(FigureConstant.THIRD_POINT, FigureConstant.FIRST_POINT);
        double s = (a + b + c) / HALF;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getName() {
        return TRIANGLE_NAME;
    }
}
