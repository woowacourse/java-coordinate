package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.AbstractFigure;

import java.util.List;

public class Rectangle extends AbstractFigure {
    private static final String INVALID_CHECK_MESSAGE = "직사각형이 아닙니다. 다시 입력해 주세요";
    private static final String NAME = "삼각형";
    private static final String RESULT_TYPE = "넓이";
    private static final int SAME_POSITION = 0;

    private Rectangle(Points points) {
        super(points);

        checkValidRectangle();
    }

    public static Rectangle newInstance(Points points) {
        return new Rectangle(points);
    }

    private void checkValidRectangle() {
        List<Point> points = this.points.getSortedPoints();

        if (matchesPoint(points)) {
            throw new IllegalArgumentException(INVALID_CHECK_MESSAGE);
        }
    }

    private boolean matchesPoint(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);

        return !checkDuplicatedPoint(p1, p2, p3, p4);
    }

    private boolean checkDuplicatedPoint(Point p1, Point p2, Point p3, Point p4) {
        return p1.differenceByX(p2) == SAME_POSITION && p3.differenceByX(p4) == SAME_POSITION
                && p1.differenceByY(p3) == SAME_POSITION && p2.differenceByY(p4) == SAME_POSITION;
    }

    @Override
    public double calculateResult() {
        return points.differenceBy(0, 1) * points.differenceBy(2, 0);
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
