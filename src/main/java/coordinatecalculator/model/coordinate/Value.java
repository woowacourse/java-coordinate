package coordinatecalculator.model.coordinate;

public class Value {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 24;

    private final int value;

    public Value(int value) {
        checkValueRange(value);
        this.value = value;
    }

    private void checkValueRange(int value) {
        if ((value < MIN_VALUE) || (value > MAX_VALUE)) {
            throw new IllegalArgumentException(MIN_VALUE + "에서 " + MAX_VALUE + "사이 값을 입력해주세요.");
        }
    }
}
