package coordinatecalculator.domain;

class AxisValidator {
    private static final String INVALID_INPUT_FORMAT_MESSAGE = "좌표 값은 자연수여야 합니다.";
    private static final String INVALID_INPUT_BOUND_MESSAGE = "좌표 값은 0이상 24이하여야 합니다.";
    private static final int AXIS_LOWER_BOUND = 0;
    private static final int AXIS_UPPER_BOUND = 24;

    void checkNumeric(String input) {
        if (!input.matches("(\\d+)?")) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_MESSAGE);
        }
    }

    void checkBoundary(int input) {
        if (input < AXIS_LOWER_BOUND || input > AXIS_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_INPUT_BOUND_MESSAGE);
        }
    }
}
