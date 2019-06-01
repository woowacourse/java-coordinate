package coordinatecalculator.model;


public class Coordinate implements Comparable<Coordinate> {

    private final static int MIN_POINT_NUMBER = 0;
    private final static int MAX_POINT_NUMBER = 24;
    private final int pointValue;

    public Coordinate(final int scannedPointValue) {
        this.pointValue = validNumber(scannedPointValue);
    }

    private int validNumber(int scannedPointValue) {
        if (scannedPointValue < MIN_POINT_NUMBER || scannedPointValue > MAX_POINT_NUMBER) {
            throw new IllegalArgumentException("0부터 24까지 정수를 입력하세요");
        }
        return scannedPointValue;
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

    @Override
    public int compareTo(Coordinate o) {
        return this.pointValue - o.pointValue;
    }
}
