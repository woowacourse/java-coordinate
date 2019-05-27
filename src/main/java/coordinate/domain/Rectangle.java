package coordinate.domain;

import java.util.Arrays;

public class Rectangle extends Figure {
    private static final int STANDARD_POINT = 0;
    private static final int RIGHT_POINT = 1;
    private static final int LEFT_POINT = 2;
    private static final int CROSS_POINT = 3;
    private static final int NINETY_DEGREE = 0;

    public Rectangle(Points points) {
        super(points);
        if (points.size() != ShapeFactory.RECTANGLE_POINT_SIZE) {
            throw new IllegalArgumentException("4개의 점으로 구성되어야 합니다");
        }
        if (!isRectangle(points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다");
        }
    }

    static boolean isRectangle(Points points) {
        Point standardPoint = points.get(STANDARD_POINT);

        Point rightVector = standardPoint.calVector(points.get(RIGHT_POINT));
        Point leftVector = standardPoint.calVector(points.get(LEFT_POINT));
        Point guessCrossPoint = standardPoint.calCrossPoint(rightVector, leftVector);
        return (isDotProductZero(rightVector, leftVector) &&
                isSameCrossPoint(guessCrossPoint, points.get(CROSS_POINT))) ? true : false;
    }

    private static boolean isDotProductZero(Point rightVector, Point leftVector) {
        return rightVector.calDotProduct(leftVector) == NINETY_DEGREE;
    }

    private static boolean isSameCrossPoint(Point guessCrossPoint, Point crossPoint) {
        return guessCrossPoint.equals(crossPoint);
    }

    public double calculateFigure() {
        double width = new Line(new Points(Arrays.asList(
                points.get(STANDARD_POINT), points.get(RIGHT_POINT)))).calculateFigure();
        double height = new Line(new Points(Arrays.asList(
                points.get(STANDARD_POINT), points.get(LEFT_POINT)))).calculateFigure();

        return width * height;
    }

    @Override
    public String toString() {
        return "사각형 넓이는 ";
    }
}
