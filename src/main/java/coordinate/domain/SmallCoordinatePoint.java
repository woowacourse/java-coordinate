package coordinate.domain;

public class SmallCoordinatePoint extends Point {
    public static final int X_BEGIN = 0, X_END = 25, Y_BEGIN = 0, Y_END = 25;

    private SmallCoordinatePoint(int x, int y) {
        super(x, y);
    }

    public static SmallCoordinatePoint of(int x, int y) {
        return new SmallCoordinatePoint(x, y);
    }

    @Override
    void validate(int x, int y) {
        if (!CoordinateRange.X_AXIS.isIn(x)) {
            throw new OutOfCoordinateException(
                    String.format("사용할 수 있는 x 의 범위를 초과했습니다. 올바른 범위: %s", CoordinateRange.X_AXIS.toString()));
        }
        if (!CoordinateRange.Y_AXIS.isIn(y)) {
            throw new OutOfCoordinateException(
                    String.format("사용할 수 있는 y 의 범위를 초과했습니다. 올바른 범위: %s", CoordinateRange.Y_AXIS.toString()));
        }
    }

    private enum CoordinateRange {
        X_AXIS(X_BEGIN, X_END), Y_AXIS(X_BEGIN, Y_END);

        private final int begin;
        private final int end;

        CoordinateRange(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        boolean isIn(int v) {
            return begin <= v && v < end;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d)", begin, end);
        }
    }
}


