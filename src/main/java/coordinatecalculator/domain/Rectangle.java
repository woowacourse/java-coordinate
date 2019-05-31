package coordinatecalculator.domain;

public class Rectangle implements Figure {
    private static final String ERROR_NOT_RECTANGLE_COORDINATE = "입력한 좌표가 직사각형이 아닙니다.";
    private static final int LEFT_BOTTOM = FigureConstant.FIRST_POINT;
    private static final int LEFT_TOP = FigureConstant.SECOND_POINT;
    private static final int RIGHT_BOTTOM = FigureConstant.THIRD_POINT;
    private static final int RIGHT_TOP = FigureConstant.FOURTH_POINT;
    private static final String RECTANGLE_NAME = "사각형";

    private PointGroup pointGroup;

    public Rectangle(final PointGroup pointGroup) {
        this.pointGroup = pointGroup;
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

    private boolean isNonOrthogonal(final int startPoint, final int middlePoint, final int endPoint) {
        double angle = pointGroup.getAngle(startPoint, middlePoint, endPoint);

        return Double.compare(Math.round(angle), FigureConstant.RIGHT_ANGLE) != FigureConstant.SAME_ANGLE;
    }

    @Override
    public double area() {
        double height = pointGroup.getLength(LEFT_BOTTOM, LEFT_TOP);
        double width = pointGroup.getLength(LEFT_BOTTOM, RIGHT_BOTTOM);

        return height * width;
    }

    @Override
    public String getName() {
        return RECTANGLE_NAME;
    }
}
