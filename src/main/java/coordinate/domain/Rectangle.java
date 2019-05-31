package coordinate.domain;

import java.util.List;

public class Rectangle extends Figure implements Polygon {
    private static final int BASE = 0;
    private static final int PAIR = 2;
    private static final int NUM_OF_POINT = 4;

    Rectangle(List<Point> points) {
        super(points, NUM_OF_POINT);
        validateRectangle(points);
    }

    private void validateRectangle(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            validateXPair(i);
            validateYPair(i);
        }
    }

    private void validateXPair(int index) {
        if (findXPairs(index).size() != PAIR)
            throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private void validateYPair(int index) {
        if (findYPairs(index).size() != PAIR)
            throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    public double calculateArea() {
        StraightLine horizontalLine = new StraightLine(findYPairs(BASE));
        StraightLine verticalLine = new StraightLine(findXPairs(BASE));
        return horizontalLine.calculateLength() * verticalLine.calculateLength();
    }

    @Override
    public double calculateAttribute() {
        return calculateArea();
    }
}