package coordinate.domain;

import java.util.Arrays;

public class Rectangle extends Figure {
    private static final String NAME = "사각형";
    private static final String OPERATION_NAME = "넓이";

    public Rectangle(Points points) {
        super(points);
        if (points.size() != 4) {
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
        Point pivPoint = points.get(0);
        Point rightPoint = points.get(1);
        Point leftPoint = points.get(2);

        Point rightVector = pivPoint.calVector(rightPoint);
        Point leftVector = pivPoint.calVector(leftPoint);

        return rightVector.calDotProduct(leftVector) == 0;
    }

    boolean isEqualCrossPoint(Points points) {
        Point pivPoint = points.get(0);
        Point rightPoint = points.get(1);
        Point leftPoint = points.get(2);
        Point crossPoint = points.get(3);

        Point rightVector = pivPoint.calVector(rightPoint);
        Point leftVector = pivPoint.calVector(leftPoint);

        return pivPoint.calCrossPoint(rightVector, leftVector).equals(crossPoint);
    }

    public double calculateFigure() {
        double width = new Line(new Points(Arrays.asList(points.get(0), points.get(1)))).calculateFigure();
        double height = new Line(new Points(Arrays.asList(points.get(0), points.get(2)))).calculateFigure();
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
