package coordinate.domain;

import java.util.Arrays;

public class Rectangle extends Figure {
    private static final int ORTHOGONAL = 0;
    private static final String NAME = "사각형";
    private static final String OPERATION_NAME = "넓이";
    private static final int POINT_COUNT = 4;
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int THIRD_POINT = 2;
    private static final int FOURTH_POINT = 3;

    public Rectangle(Points points) {
        super(points);
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("4개의 점으로 구성되어야 합니다");
        }
        if (!isRectangle(points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    boolean isRectangle(Points points) {
        return (isOrthogonal(points) && isEqualCrossPoint(points));
    }

    boolean isOrthogonal(Points points) {
        Point rightVector = points.get(FIRST_POINT).calVector(points.get(SECOND_POINT));
        Point leftVector = points.get(FIRST_POINT).calVector(points.get(THIRD_POINT));

        return rightVector.calDotProduct(leftVector).equals(new Scalar(ORTHOGONAL));
    }

    boolean isEqualCrossPoint(Points points) {
        Point rightVector = points.get(FIRST_POINT).calVector(points.get(SECOND_POINT));
        Point leftVector = points.get(FIRST_POINT).calVector(points.get(THIRD_POINT));

        return points.get(FIRST_POINT).calCrossPoint(rightVector, leftVector).equals(points.get(FOURTH_POINT));
    }

    public double calculateFigure() {
        double width = new Line(new Points(Arrays.asList(points.get(FIRST_POINT), points.get(SECOND_POINT)))).calculateFigure();
        double height = new Line(new Points(Arrays.asList(points.get(FIRST_POINT), points.get(THIRD_POINT)))).calculateFigure();
        return width * height;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getOperationName() {
        return OPERATION_NAME;
    }
}
