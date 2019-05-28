package coordinatecalculator.domain;

public class Rectangle extends AbstractFigure {
    private static final String ERROR_NOT_RECTANGLE_COORDINATE = "입력한 좌표가 직사각형이 아닙니다.";
    private static final int LEFT_BOTTOM = FigureConstant.FIRST_POINT;
    private static final int LEFT_TOP = FigureConstant.SECOND_POINT;
    private static final int RIGHT_BOTTOM = FigureConstant.THIRD_POINT;
    private static final int RIGHT_TOP = FigureConstant.FOURTH_POINT;
    private static final String RECTANGLE_NAME = "사각형";

    public Rectangle(final PointGroup points) {
        super(points);
        checkValidRectangle();
    }

    private void checkValidRectangle() {
        if (hasNonOrthogonal()) {
            throw new IllegalArgumentException(ERROR_NOT_RECTANGLE_COORDINATE);
        }
    }

    private boolean hasNonOrthogonal() {
        return isNonOrthogonal(LEFT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM)
                || isNonOrthogonal(RIGHT_TOP, LEFT_TOP, LEFT_BOTTOM)
                || isNonOrthogonal(RIGHT_TOP, RIGHT_BOTTOM, LEFT_BOTTOM)
                || isNonOrthogonal(LEFT_TOP, RIGHT_TOP, RIGHT_BOTTOM);
    }

    private boolean isNonOrthogonal(final int firstPoint, final int secondPoint, final int thirdPoint) {
        double angle = getAngle(firstPoint, secondPoint, thirdPoint);
        return Double.compare(Math.round(angle), FigureConstant.RIGHT_ANGLE) != FigureConstant.SAME_ANGLE;
    }

    private double getAngle(final int firstPoint, final int secondPoint, final int thirdPoint) {
        return getPoint(firstPoint).getAngle(getPoint(secondPoint), getPoint(thirdPoint));
    }

    @Override
    public double area() {
        double height = getPoint(LEFT_BOTTOM).getDistance(getPoint(LEFT_TOP));
        double width = getPoint(LEFT_BOTTOM).getDistance(getPoint(RIGHT_BOTTOM));

        return height * width;
    }

    @Override
    public String getName() {
        return RECTANGLE_NAME;
    }
}
