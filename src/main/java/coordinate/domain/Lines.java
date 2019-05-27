package coordinate.domain;

import java.util.List;

public class Lines {
    private static final int TRIANGLE_LONGEST_LENGTH_INDEX = 0;
    private static final int TRIANGLE_SECOND_LONGEST_LENGTH_INDEX = 1;
    private static final int TRIANGLE_THIRD_LONGEST_LENGTH_INDEX = 2;
    private static final int SQUARE_SECOND_LONGEST_LENGTH_INDEX = 3;
    private static final int SQUARE_THIRD_LONGEST_LENGTH_INDEX = 5;
    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int getLinesLength() {
        return this.lines.size();
    }

    public boolean isNotEqual(int index) {
        return !lines.get(index).equals(lines.get(index + 1));
    }

    public double calculateSquareArea() {
        return lines.get(SQUARE_SECOND_LONGEST_LENGTH_INDEX).calculateSquareArea(lines.get(SQUARE_THIRD_LONGEST_LENGTH_INDEX));
    }

    public boolean isNotTriangle() {
        return !lines.get(TRIANGLE_LONGEST_LENGTH_INDEX).isTriangle(lines.get(TRIANGLE_SECOND_LONGEST_LENGTH_INDEX),
                lines.get(TRIANGLE_THIRD_LONGEST_LENGTH_INDEX));
    }

    public double calculateTriangleArea() {
        return lines.get(TRIANGLE_LONGEST_LENGTH_INDEX).calculateTriangleArea(
                lines.get(TRIANGLE_SECOND_LONGEST_LENGTH_INDEX),
                lines.get(TRIANGLE_THIRD_LONGEST_LENGTH_INDEX));
    }
}
