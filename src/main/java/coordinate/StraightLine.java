package coordinate;

public class StraightLine {
    private final Point p1;
    private final Point p2;

    public StraightLine(Point p1, Point p2) {
        validateDifferentPoint(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }

    private void validateDifferentPoint(Point p1, Point p2) {
        if (p1.equals(p2)) {
            throw new IllegalArgumentException("직선의 두 점은 같을 수가 없습니다.");
        }
    }

    public double calculateDistance() {
        return Math.sqrt(Math.pow(calculateXDifference(), 2) + Math.pow(calculateYDifference(), 2));
    }

    private int calculateXDifference() {
        return p1.getX() - p2.getX();
    }

    private int calculateYDifference() {
        return p1.getY() - p2.getY();
    }
}