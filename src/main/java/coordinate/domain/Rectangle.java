package coordinate.domain;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Rectangle {
    private static final int NUM_OF_LINES = 4;

    private final Lines lines;

    public Rectangle(Lines lines) {
        validateNotNull(lines);
        validateNumOf(lines);
        validateRectangle(lines);
        this.lines = lines;
    }

    private void validateNumOf(Lines lines) {
        if (lines.getSize() != NUM_OF_LINES) {
            throw new IllegalArgumentException("직사각형은 4개의 선분을 가져야 합니다.");
        }
    }

    private void validateRectangle(Lines lines) {
        if (!hasVerticalLines(lines)) {
            throw new IllegalArgumentException("직사각형은 4개의 직각을 가져야 합니다.");
        }
    }

    private boolean hasVerticalLines(Lines lines) {
        boolean isValidate = true;
        for (int i = 0; i < NUM_OF_LINES - 1; i++) {
            isValidate &= lines.isOrthogonal(i, i+1);
        }
        return isValidate;
    }

    public double area() {
        return lines.getLine(0).calculateDistance()
                * lines.getLine(1). calculateDistance();
    }
}