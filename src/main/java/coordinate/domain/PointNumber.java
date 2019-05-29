package coordinate.domain;

import coordinate.domain.exceptions.OutOfRangeException;

import java.util.HashMap;
import java.util.Map;

class PointNumber {
    private static final int minNumber = Math.min(Point.MIN_X, Point.MIN_Y);
    private static final int maxNumber = Math.max(Point.MAX_X, Point.MAX_Y);
    private static final Map<Integer, PointNumber> NUMBERS = new HashMap<>();

    static {
        for (int i = minNumber; i <= maxNumber; i++) {
            NUMBERS.put(i, new PointNumber(i));
        }
    }

    private int value;

    private PointNumber(int value) {
        this.value = value;
    }

    static PointNumber valueOf(int value) {
        PointNumber pointNumber = NUMBERS.get(value);
        if (pointNumber == null) {
            throw new OutOfRangeException(String.format("value : %d is out of range.", value));
        }
        return NUMBERS.get(value);
    }


    int getValue() {
        return value;
    }

    int minus(PointNumber obj) {
        return value - obj.getValue();
    }
}
