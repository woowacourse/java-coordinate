package coordinate.domain;

import java.util.*;

public class Triangle extends Figure implements CalculableFigure {
    private static final int BASE = 0;
    private static final int NUM_OF_POINT = 3;
    private static final int UNIQUE_SIZE = 1;

    Triangle(List<Point> points) {
        super(points);
        validateSizeOf(points);
        validateTriangle(points);
        this.points = points;
    }

    public static Triangle create(List<Point> points) {
        return new Triangle(points);
    }

    private void validateSizeOf(List<Point> points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 " + NUM_OF_POINT + " 개여야 합니다.");
        }
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

    @Override
    public double calculateArea() {
        List<Double> lengths = getLengthOfSideLines();
        Iterator<Double> lengthIterator = lengths.iterator();
        return applyHeronFormula(lengthIterator.next(), lengthIterator.next(), lengthIterator.next());
    }

    private List<Double> getLengthOfSideLines() {
        List<Double> lineLength = new ArrayList<>();

        for (Point point : points) {
            List<Point> points = new ArrayList<>(this.points);
            points.remove(point);
            lineLength.add(new StraightLine(points).calculateArea());
        }
        return lineLength;
    }

    private double applyHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
