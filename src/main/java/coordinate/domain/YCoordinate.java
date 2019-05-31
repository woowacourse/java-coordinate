package coordinate.domain;

import java.util.HashMap;
import java.util.Map;

class YCoordinate extends Coordinate {
    private static final int Y_MIN_VALUE = 1;
    private static final int Y_MAX_VALUE = 24;

    private static final Map<Integer, YCoordinate> Y_POOL = new HashMap<>();

    static {
        for (int i = Y_MIN_VALUE; i <= Y_MAX_VALUE; i++) {
            Y_POOL.put(i, new YCoordinate(i));
        }
    }

    private YCoordinate(int coordinate) {
        super(coordinate);
    }

    static YCoordinate of(int coordinate) {
        if (Y_POOL.containsKey(coordinate)) {
            return Y_POOL.get(coordinate);
        }
        throw new IllegalArgumentException("좌표 값은 " + Y_MAX_VALUE + "와 " + Y_MIN_VALUE + " 사이여야 합니다.");
    }
}
