package location.domain;

public class Line {
    public static final String DUPLICATE_POINT_MSG = "중복된 점입니다.";

    private final Point point1;
    private final Point point2;

    public Line(final Point point1, final Point point2) {
        isValid(point1, point2);
        this.point1 = point1;
        this.point2 = point2;
    }

    private void isValid(final Point point1, final Point point2) {
        if (point1.equals(point2)) {
            throw new IllegalArgumentException(DUPLICATE_POINT_MSG);
        }
    }

    public double calculate() {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }
}
