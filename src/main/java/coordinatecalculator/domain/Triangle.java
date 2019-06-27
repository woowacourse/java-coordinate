package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.AbstractFigure;

import java.math.BigDecimal;
import java.util.List;

public class Triangle extends AbstractFigure {
    private static final String INVALID_TRIANGLE_MESSAGE = "세 점이 일직선 상에 위치할 수는 없습니다. 다시 입력해주세요.";
    private static final String NAME = "삼각형";
    private static final String RESULT_TYPE = "넓이";
    private static final int SAME_POSITION = 0;
    private static final BigDecimal HERON_NUMBER = BigDecimal.valueOf(2);

    private Triangle(Points points) {
        super(points);

        checkValidTriangle();
    }

    public static Triangle newInstance(Points points) {
        return new Triangle(points);
    }

    private void checkValidTriangle() {
        List<Point> points = this.points.getSortedPoints();
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        checkOnSameXAxis(point1, point2, point3);
        checkOnSameExtension(point1, point2, point3);
    }

    private void checkOnSameXAxis(Point p1, Point p2, Point p3) {
        if (p1.differenceByX(p2) == SAME_POSITION && p2.differenceByX(p3) == SAME_POSITION) {
            throw new IllegalArgumentException(INVALID_TRIANGLE_MESSAGE);
        }
    }

    private void checkOnSameExtension(Point p1, Point p2, Point p3) {
        int x1 = p1.differenceByX(p2);
        int y1 = p1.differenceByY(p2);
        int x2 = p3.differenceByX(p2);
        int y2 = p3.differenceByY(p2);

        if ((double) y1 / x1 == (double) y2 / x2) {
            throw new IllegalArgumentException(INVALID_TRIANGLE_MESSAGE);
        }
    }

    @Override
    public double calculateResult() {
        BigDecimal side1 = BigDecimal.valueOf(points.differenceBy(0, 1));
        BigDecimal side2 = BigDecimal.valueOf(points.differenceBy(1, 2));
        BigDecimal side3 = BigDecimal.valueOf(points.differenceBy(2, 0));

        BigDecimal s = side1.add(side2).add(side3).divide(HERON_NUMBER);

        return Math.sqrt(s.multiply(s.subtract(side1)).multiply(s.subtract(side2)).multiply(s.subtract(side3)).doubleValue());
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getResultType() {
        return RESULT_TYPE;
    }
}
