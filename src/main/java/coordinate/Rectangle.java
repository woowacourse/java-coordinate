package coordinate;

import static util.NotNullValidator.validateNotNull;

public class Rectangle {
    private static final int LEFT_BOTTOM_POINT = 0;
    private static final int LEFT_TOP_POINT = 1;
    private static final int RIGHT_BOTTOM_POINT = 2;
    private static final int RIGHT_TOP_POINT = 3;
    private static final int POINTS_SIZE = 4;

    private final Lines lines;

    public Rectangle(Lines lines) {
        validateNotNull(lines);
        validateNumOf(lines);
        this.lines = lines;
        validateRectangle();
    }

    private void validateNumOf(Lines lines) {
        if (lines.getSize() != POINTS_SIZE) {
            throw new IllegalArgumentException("직사각형은 4개의 점을 가져야 합니다.");
        }
    }

    private void validateRectangle() {
        boolean isValidate = true;
        for (int i=0; i<3; i++) {
            isValidate &= checkVerticalLines(lines.getLine(i), lines.getLine(i+1));
        }
        isValidate &= checkVerticalLines(lines.getLine(3), lines.getLine(0));

        if (!isValidate) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean checkVerticalLines(Line line1, Line line2) {
        if (line1.isHorizontal() || line1.isVertical()) {
            return (line1.isHorizontal() && line2.isVertical()) || (line1.isVertical() && line2.isHorizontal());
        }
        return Double.compare(line1.calculateSlope() * line2.calculateSlope(), -1) == 0;
    }

    public double area() {
        return lines.getLine(0).calculateDistance() * lines.getLine(1).calculateDistance();
    }
}
