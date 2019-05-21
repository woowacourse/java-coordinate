package coordinate;

import java.util.Arrays;

import static util.NotNullValidator.validateNotNull;

public class Line {
    private final Points points;

    public static Line createLine(Point p1, Point p2) {
        return new Line(new Points(Arrays.asList(p1, p2)));
    }

    public Line(Points points) {
        validateNotNull(points);
        validateNumOf(points);
        this.points = points;
    }

    private void validateNumOf(Points points) {
        if (points.getSize() != 2) {
            throw new IllegalArgumentException("직선은 두 개의 점을 가져야합니다.");
        }
    }

    public double calculateDistance() {
        return Math.sqrt(Math.pow(calculateXDifference(), 2) + Math.pow(calculateYDifference(), 2));
    }

    private int calculateXDifference() {
        return points.getX(0) - points.getX(1);
    }

    private int calculateYDifference() {
        return points.getY(0) - points.getY(1);
    }

    public double calculateSlope() {
        return (double) (points.getY(1) - points.getY(0))
                / (points.getX(1) - points.getX(0));
    }
}