package coordinate.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Rectangle {
    private static final int BASE = 0;
    private static final int PAIR = 2;
    private static final int NUM_OF_POINT = 4;
    private List<Point> points;

    public Rectangle(List<Point> points) {
        validateDuplicate(points);
        validateSizeOf(points);
        validateRectangle(points);
        this.points = points;
    }

    private void validateDuplicate(List<Point> points) {
        if (points.size() != (new HashSet<>(points)).size()) {
            throw new IllegalArgumentException("같은 점은 입력할 수 없습니다.");
        }
    }


    private void validateSizeOf(List<Point> points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 네개여야 합니다.");
        }
    }

    private void validateRectangle(List<Point> points) {
        for (Point point : points) {
            validateXPair(points, point);
            validateYPair(points, point);
        }
    }

    private void validateXPair(List<Point> points, Point point) {
        if (findXPair(points, point).size() != PAIR)
            throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private List<Point> findXPair(List<Point> points, Point point) {
        return points.stream().filter(p -> p.matchX(point)).collect(Collectors.toList());
    }

    private void validateYPair(List<Point> points, Point point) {
        if (findYPair(points, point).size() != PAIR)
            throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private List<Point> findYPair(List<Point> points, Point point) {
        return points.stream().filter(p -> p.matchY(point)).collect(Collectors.toList());
    }

    public double calculateArea() {
        StraightLine horizontalLine = new StraightLine(findYPair(points, points.get(BASE)));
        StraightLine verticalLine = new StraightLine(findXPair(points, points.get(BASE)));
        return horizontalLine.calculateLength() * verticalLine.calculateLength();
    }
}
