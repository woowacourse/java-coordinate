package coordinate.domain;

import java.util.List;

public class Rectangle implements Figure {
    private final double area;

    public Rectangle(final Points points) {
        validate(points);
        this.area = calculateArea(points);
    }

    private void validate(final Points points) {
        validatePointSize(points);
        List<Point> figure = points.getPoints();
        Point firstPoint = figure.remove(0);
        Point secondPoint = oppositePoint(firstPoint, figure);
        compareCross(figure, firstPoint, secondPoint);
    }

    private void validatePointSize(Points points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException("사각형이 아닙니다");
        }
    }

    private Point oppositePoint(final Point point, final List<Point> figure) {
        int maxDistance = 0;
        int maxIndex = 0;
        for (int i = 0; i < figure.size(); i++) {
            int distanceSqure = point.distanceSqure((figure.get(i)));
            if (maxDistance < distanceSqure) {
                maxDistance = distanceSqure;
                maxIndex = i;
            }
        }
        return figure.remove(maxIndex);
    }

    private void compareCross(final List<Point> points, final Point firstPoint, final Point secondPoint) {
        if (crossLine(firstPoint, points) != crossLine(secondPoint, points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private int crossLine(final Point firstPoint, final List<Point> figure) {
        int first = firstPoint.distanceSqure(figure.get(0));
        int second = firstPoint.distanceSqure(figure.get(1));
        int cross = figure.get(0).distanceSqure(figure.get(1));
        if (first + second == cross) {
            return cross;
        }
        throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private double calculateArea(final Points points) {
        double result = 1;
        List<Point> figure = points.getPoints();
        Point firstPoint = figure.remove(0);
        oppositePoint(firstPoint, figure);
        for (Point point : figure) {
            result *= point.getDistance(firstPoint);
        }
        return result;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "사각형 넓이는 " + area;
    }
}
