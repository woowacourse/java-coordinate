package coordinate.domain;

import java.util.HashMap;
import java.util.Map;

class XCoordinate extends Coordinate {
    private static final int X_MIN_VALUE = 1;
    private static final int X_MAX_VALUE = 24;

    private static final Map<Integer, XCoordinate> X_POOL = new HashMap<>();

    static {
        for (int i = X_MIN_VALUE; i <= X_MAX_VALUE; i++) {
            X_POOL.put(i, new XCoordinate(i));
        }
    }

    private XCoordinate(int coordinate) {
        super(coordinate);
    }

    static XCoordinate of(int coordinate) {
        if (X_POOL.containsKey(coordinate)) {
            return X_POOL.get(coordinate);
        }
        throw new IllegalArgumentException("좌표 값은 " + X_MAX_VALUE + "와 " + X_MIN_VALUE + " 사이여야 합니다.");
    }
}
