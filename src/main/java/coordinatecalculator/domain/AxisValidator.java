package coordinatecalculator.domain;

public class AxisValidator {
    protected final static int AXIS_LOWER_BOUND = 0;
    protected final static int AXIS_UPPER_BOUND = 24;

    protected void checkNumeric(String input) {
        if (!input.matches("(\\d+)?")) {
            throw new IllegalArgumentException("좌표 값은 자연수여야 합니다.");
        }
    }

    protected void checkBoundary(int input) {
        if (input < AXIS_LOWER_BOUND || input > AXIS_UPPER_BOUND) {
            throw new IllegalArgumentException("좌표 값은 0이상 24이하여야 합니다.");
        }
    }
}
