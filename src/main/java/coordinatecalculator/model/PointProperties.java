package coordinatecalculator.model;

public abstract class PointProperties {
    private static final int MIN_POINT_NUMBER = 0;
    private static final int MAX_POINT_NUMBER = 24;

    public abstract int getValue();

    public abstract int subtract(int anotherPointValue);

    protected int validNumber(int pointValue) {
        if (pointValue < MIN_POINT_NUMBER || pointValue > MAX_POINT_NUMBER) {
            throw new IllegalArgumentException("0부터 24까지 정수를 입력하세요");
        }
        return pointValue;
    }
}
