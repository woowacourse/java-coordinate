package coordinate.domain;

public class Rectangle extends Polygon {
    private static final int NUM_OF_LINES = 4;

    public Rectangle(Lines lines) {
        super(lines);
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
            isValidate &= lines.isOrthogonal(i, i + 1);
        }
        return isValidate;
    }

    @Override
    public double area() {
        return areaOfParallelogram();
    }

    @Override
    public String getClassName() {
        return "사각형";
    }
}