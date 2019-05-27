package coordinatecalculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinate {

    private final static int MIN_POINT_NUMBER = 0;
    private final static int MAX_POINT_NUMBER = 24;
    private final static String NUMBER_REGEX = "[0-9]*";
    private final int pointValue;

    public Coordinate(final String scannedPointValue) {
        this.pointValue = validNumber(scannedPointValue);
    }

    private int validNumber(String scannedPointValue) {
        Matcher matcher = Pattern.compile(NUMBER_REGEX).matcher(scannedPointValue);
        if (!matcher.find()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        if (Integer.parseInt(scannedPointValue) < MIN_POINT_NUMBER || Integer.parseInt(scannedPointValue) > MAX_POINT_NUMBER) {
            throw new IllegalArgumentException("0부터 24까지 정수를 입력하세요");
        }
        return Integer.parseInt(scannedPointValue);
    }

    public int getValue() {
        return pointValue;
    }

    public int subtract(Coordinate anotherCoordinate) {
        return this.pointValue - anotherCoordinate.pointValue;
    }

    @Override
    public String toString() {
        return String.format("%d", pointValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;
        return pointValue == that.pointValue;
    }

    @Override
    public int hashCode() {
        return pointValue;
    }
}
