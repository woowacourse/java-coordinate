package coordinatecalculator.domain;

import java.util.Objects;

public class AxisValue {
    private static final String INVALID_INPUT_FORMAT_MESSAGE = "좌표 값은 자연수여야 합니다.";
    private static final String INVALID_INPUT_BOUND_MESSAGE = "좌표 값은 0이상 24이하여야 합니다.";
    private static final int AXIS_LOWER_BOUND = 0;
    private static final int AXIS_UPPER_BOUND = 24;

    private final int value;

    public AxisValue(final String value) {
        checkNumeric(value);
        checkBoundary(Integer.parseInt(value));
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    private void checkNumeric(String input) {
        if (!input.matches("(\\d+)?")) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_MESSAGE);
        }
    }

    private void checkBoundary(int input) {
        if (input < AXIS_LOWER_BOUND || input > AXIS_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_INPUT_BOUND_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxisValue axisValue1 = (AxisValue) o;
        return Objects.equals(value, axisValue1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
