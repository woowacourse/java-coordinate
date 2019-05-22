package coordinate.domain;

import java.util.List;

public class RectangleCalculator {
    double area;

    public RectangleCalculator(Figure figure) {
        if (figure.size() != 4) {
            throw new IllegalArgumentException("사각형이 아닙니다");
        }
        validate(figure);
        this.area = calculateArea(figure);
    }

    private void validate(Figure figure) {
        List<Point> points = figure.getPoints();
        Point firstPoint = points.remove(0);
        Point secondPoint = oppositePoint(firstPoint, points);

        compareCross(points, firstPoint, secondPoint);
    }

    private Point oppositePoint(Point firstPoint, List<Point> points) {
        int maxDistance = 0;
        int maxIndex = 0;
        for (int i = 0; i < points.size(); i++) {
            int distanceSqure = firstPoint.distanceSqure((points.get(i)));
            if (maxDistance < distanceSqure) {
                maxDistance = distanceSqure;
                maxIndex = i;
            }
        }
        return points.remove(maxIndex);
    }

    private void compareCross(List<Point> points, Point firstPoint, Point secondPoint) {
        if (crossLine(firstPoint, points) != crossLine(secondPoint, points)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private int crossLine(Point firstPoint, List<Point> points) {
        int first = firstPoint.distanceSqure(points.get(0));
        int second = firstPoint.distanceSqure(points.get(1));
        int cross = points.get(0).distanceSqure(points.get(1));
        if (first + second == cross) {
            return cross;
        }
        throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private double calculateArea(Figure figure) {
        double result = 1;
        List<Point> points = figure.getPoints();
        Point firstPoint = points.remove(0);
        oppositePoint(firstPoint, points);
        for (Point point : points) {
            result *= point.getDistance(firstPoint);
        }
        return result;
    }

    public double getArea() {
        return area;
    }
}
