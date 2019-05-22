package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Rectangle extends Figure {
    private static final int LINES_SIZE = 4;
    private static final int TRIANGLE_LINE_SIZE = 3;
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
        return currentLine.isHorizontal()
                || currentLine.isVertical();
    }

    private boolean checkParallelAxisVertical(Line currentLine, Line nextLine) {
        return checkCurrentLineHorizontalAxis(currentLine, nextLine)
                || checkCurrentLineVerticalAxis(currentLine, nextLine);
    }

    private boolean checkCurrentLineHorizontalAxis(Line currentLine, Line nextLine) {
        return currentLine.isHorizontal() && nextLine.isVertical();
    }

    private boolean checkCurrentLineVerticalAxis(Line currentLine, Line nextLine) {
        return currentLine.isVertical() && nextLine.isHorizontal();
    }

    private boolean checkTiledVertical(Line currentLine, Line nextLine) {
        return Double.compare(currentLine.calculateSlope()
                * nextLine.calculateSlope(), SLOPE_MULTIPLE) == COMPARE_SLOPE_MULTIPLE;
    }

    @Override
    public double area(List<Double> lineDistance) {
        lineDistance = createTriangle();
        return super.area(lineDistance) * 2;
    }

    public List<Double> createTriangle() {
        List<Double> lineDistance = new ArrayList<>();
        for (int i = 0; i < TRIANGLE_LINE_SIZE - 1; i++) {
            lineDistance.add(lines.getLine(i).calculateDistance());
        }
        lineDistance.add((diagonalDistance()));
        return lineDistance;
    }

    private double diagonalDistance() {
        return Math.sqrt(Math.pow(lines.getLine(FIRST_LINE_NUMBER).calculateDistance(), 2)
                + Math.pow(lines.getLine(LAST_LINE_NUMBER).calculateDistance(), 2));
    }
}
