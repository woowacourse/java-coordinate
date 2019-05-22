package coordinatecalculator;

public class Point {
    private static final int UNDER_LIMIT = 1;
    private static final int UPPER_LIMIT = 24;
    private static final String MSG_LIMIT_OVER = "좌표 범위를 초과하였습니다.";

    private int x;
    private int y;

    public Point(int x, int y) {
        if (isLimitOver(x) || isLimitOver(y)) {
            throw new IllegalArgumentException(MSG_LIMIT_OVER);
        }

        this.x = x;
        this.y = y;
    }

    private boolean isLimitOver(int x) {
        return (x > UPPER_LIMIT || x < UNDER_LIMIT);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double getDistance(Point anotherPoint) {
        double x = minusAndPow(this.x, anotherPoint.x);
        double y = minusAndPow(this.y, anotherPoint.y);
        return Math.sqrt(x + y);
    }

    private double minusAndPow(int x1, int x2) {
        return Math.pow((x2 - x1), 2);
    }
}
