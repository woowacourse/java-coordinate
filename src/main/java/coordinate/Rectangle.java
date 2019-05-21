package coordinate;

import static util.NotNullValidator.validateNotNull;

public class Rectangle {
    private static final int LINES_SIZE = 4;
    private static final int FIRST_LINE_NUMBER = 0;
    private static final int LAST_LINE_NUMBER = 3;
    private static final int SLOPE_MULTIPLE = -1;
    private static final int COMPARE_SLOPE_MULTIPLE = 0;

    private final Lines lines;

    public Rectangle(Lines lines) {
        validateNotNull(lines);
        validateNumOf(lines);
        this.lines = lines;
        validateFigure();
    }

    private void validateNumOf(Lines lines) {
        if (lines.getSize() != LINES_SIZE) {
            throw new IllegalArgumentException("직사각형은 4개의 라인을 가져야 합니다.");
        }
    }

    private void validateFigure() {
        if (!hasVerticalLines()) {
            throw new IllegalArgumentException("직사각형은 4개의 직각을 가져야 합니다.");
        }
    }

    private boolean hasVerticalLines() {
        boolean isValidate = true;

        for (int i = FIRST_LINE_NUMBER; i < LAST_LINE_NUMBER; i++) {
            isValidate &= checkVerticalLines(lines.getLine(i), lines.getLine(i + 1));
        }
        isValidate &= checkVerticalLines(lines.getLine(LAST_LINE_NUMBER), lines.getLine(FIRST_LINE_NUMBER));

        return isValidate;
    }

    private boolean checkVerticalLines(Line currentLine, Line nextLine) {
        if (hasParallelAxis(currentLine)) {
            return checkParallelAxisVertical(currentLine, nextLine);
        }
        return checkTiledVertical(currentLine, nextLine);
    }

    private boolean hasParallelAxis(Line currentLine) {
        return currentLine.hasHorizontalAxisParallel()
                || currentLine.hasVerticalAxisParallel();
    }

    private boolean checkParallelAxisVertical(Line currentLine, Line nextLine) {
        return checkCurrentLineHorizontalAxis(currentLine, nextLine)
                || checkCurrentLineVerticalAxis(currentLine, nextLine);
    }

    private boolean checkCurrentLineHorizontalAxis(Line currentLine, Line nextLine) {
        return currentLine.hasHorizontalAxisParallel() && nextLine.hasVerticalAxisParallel();
    }

    private boolean checkCurrentLineVerticalAxis(Line currentLine, Line nextLine) {
        return currentLine.hasVerticalAxisParallel() && nextLine.hasHorizontalAxisParallel();
    }

    private boolean checkTiledVertical(Line currentLine, Line nextLine) {
        return Double.compare(currentLine.calculateSlope()
                * nextLine.calculateSlope(), SLOPE_MULTIPLE) == COMPARE_SLOPE_MULTIPLE;
    }

    public double area() {
        return lines.getLine(FIRST_LINE_NUMBER).calculateDistance()
                * lines.getLine(LAST_LINE_NUMBER).calculateDistance();
    }
}
