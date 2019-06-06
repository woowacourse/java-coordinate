package coordinate.domain;

import java.util.*;

public class Triangle extends Figure implements CalculableFigure {
    private static final int BASE = 0;
    private static final int NUM_OF_POINT = 3;
    private static final int UNIQUE_SIZE = 1;

    Triangle(Points points) {
        super(points);
    }

    @Override
    void validateConfigurableBy(Points points) {
        validateSizeOf(points);
        validateTriangle(points);
    }

    private void validateSizeOf(Points points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 " + NUM_OF_POINT + " 개여야 합니다.");
        }
    }

    private void validateTriangle(Points points) {
        Set<Double> slopes = new HashSet<>();
        Point basePoint = points.get(BASE);

        for (int i = 1; i < points.size(); i++) {
            Points twoPoints = Points.of(Arrays.asList(basePoint, points.get(i)));
            slopes.add(new StraightLine(twoPoints).calculateSlope());
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

        for (Point point : points.getAllPoints()) {
            List<Point> points = new ArrayList<>(this.points.getAllPoints());
            points.remove(point);
            lineLength.add(new StraightLine(Points.of(points)).calculateArea());
        }
        return lineLength;
    }

    private double applyHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
