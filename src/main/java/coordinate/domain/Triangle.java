package coordinate.domain;

import java.util.*;

public class Triangle extends Figure {
    private static final int NUM_OF_POINT = 3;
    private static final int UNIQUE_SIZE = 1;

    private List<Point> points;

    public Triangle(List<Point> points) {
        validateDuplicate(points);
        validateSizeOf(points, NUM_OF_POINT);
        validateTriangle(points);
        this.points = points;
    }

    private void validateTriangle(List<Point> points) {
        Set<Double> slopes = new HashSet<>();
        Point basePoint = points.get(BASE);

        for (int i = 1; i < points.size(); i++) {
            slopes.add((new StraightLine(Arrays.asList(basePoint, points.get(i)))).calculateSlope());
        }

        if (slopes.size() == UNIQUE_SIZE) {
            throw new IllegalArgumentException("한 직선에 세 개의 점이 있을 수 없습니다.");
        }
    }

    public double calculateArea() {
        List<Double> lengths = getSideLength();
        Iterator<Double> lengthIterator = lengths.iterator();
        return applyHeronFormula(lengthIterator.next(), lengthIterator.next(), lengthIterator.next());
    }

    private List<Double> getSideLength() {
        List<Double> lineLength = new ArrayList<>();

        for (Point point : points) {
            List<Point> points = new ArrayList<>(this.points);
            points.remove(point);
            lineLength.add(new StraightLine(points).calculateLength());
        }
        return lineLength;
    }

    private double applyHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
