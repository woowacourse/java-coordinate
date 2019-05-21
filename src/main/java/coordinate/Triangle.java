package coordinate;

import static util.NotNullValidator.validateNotNull;

public class Triangle {
    private static final int POINTS_SIZE = 3;

    private final Points points;

    public Triangle(Points points) {
        validateNotNull(points);
        validateNumOf(points);
        this.points = points;
    }

    private void validateNumOf(Points points) {
        if (points.getSize() != POINTS_SIZE) {
            throw new IllegalArgumentException("삼각형은 3개의 점을 가져야 합니다.");
        }
    }


    public boolean checkSameSlope() {
        return Double.compare(calculateSlope(points.get(0), points.get(1))
                , calculateSlope(points.get(1), points.get(2))) == 0;
    }

    private double calculateSlope(Point p1, Point p2) {
        return (double) (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }
}
