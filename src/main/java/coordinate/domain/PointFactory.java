package coordinate.domain;

public class PointFactory {
    private final int xBegin, xEnd, yBegin, yEnd;

    private PointFactory(int xBegin, int xEnd, int yBegin, int yEnd) {
        this.xBegin = xBegin;
        this.xEnd = xEnd;
        this.yBegin = yBegin;
        this.yEnd = yEnd;

        validate(xBegin, xEnd, yBegin, yEnd);
    }

    private void validate(int xBegin, int xEnd, int yBegin, int yEnd) {
        if (!(xBegin < xEnd)) {
            throw new IllegalArgumentException(String.format("x 범위에 존재할 수 있는 점이 없습니다. [%d, %d)", xBegin, xEnd));
        }
        if (!(yBegin < yEnd)) {
            throw new IllegalArgumentException(String.format("y 범위에 존재할 수 있는 점이 없습니다. [%d, %d)", yBegin, yEnd));
        }
    }

    public static PointFactory of(int xBegin, int xEnd, int yBegin, int yEnd) {
        return new PointFactory(xBegin, xEnd, yBegin, yEnd);
    }

    public Point createPoint(int x, int y) {
        if (!isIn(xBegin, xEnd, x) || !isIn(yBegin, yEnd, y)) {
            throw new IllegalArgumentException("범위를 초과한 입력입니다. ");
        }
        return new Point(x, y);
    }

    private boolean isIn(int begin, int end, int v) {
        return begin <= v && v < end;
    }
}
