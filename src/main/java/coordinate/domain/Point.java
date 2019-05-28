package coordinate.domain;

public class Point {
    private static final int MAX_X = 24;
    private static final int MAX_Y = 24;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        validate();
        this.x = x;
        this.y = y;
    }

    private void validate() {
        validateX();
        validateY();
    }

    private void validateX() {
        if (x > MAX_X || x < MIN_X) {
            throw new IllegalArgumentException("x의 좌표값은 " + MIN_X + "이상 " + MAX_X + "이하 입니다.");
        }
    }

    private void validateY() {
        if (y > MAX_Y || x < MIN_Y) {
            throw new IllegalArgumentException("y의 좌표값은 " + MIN_Y + "이상 " + MAX_Y + "이하 입니다.");
        }
    }

    public double getDistance(final Point point) {
        return Math.sqrt(Math.pow((x - point.x), 2) + Math.pow((y - point.y), 2));
    }

    public int distanceSquare(final Point point) {
        int absX = x - point.x;
        int absY = y - point.y;
        return absX * absX + absY * absY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
