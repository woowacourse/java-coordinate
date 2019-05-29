package coordinate.domain;

import java.util.HashMap;
import java.util.Map;

class NumberForPoint {
    private static final int minNumber = Math.min(Point.MIN_X, Point.MIN_Y);
    private static final int maxNumber = Math.max(Point.MAX_X, Point.MAX_Y);
    private static final Map<Integer, NumberForPoint> NUMBERS = new HashMap<>();

    static {
        for (int i = minNumber; i <= maxNumber; i++) {
            NUMBERS.put(i, new NumberForPoint(i));
        }
    }

    private int value;

    private NumberForPoint(int value) {
        this.value = value;
    }

    static NumberForPoint valueOf(int value) {
        NumberForPoint numberForPoint = NUMBERS.get(value);
        if (numberForPoint == null) {
            throw new OutOfRangeException(String.format("value : %d is out of range.", value));
        }
        return NUMBERS.get(value);
    }

    int getValue() {
        return value;
    }
}
