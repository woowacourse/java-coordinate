package coordinate.domain;

public class Square implements Figure {
    private static final int SQUARE_SECOND_LONGEST_LENGTH_INDEX = 3;
    private static final int SQUARE_THIRD_LONGEST_LENGTH_INDEX = 5;
    static final int POINT_NUMBER = 4;
    private Lines lines;

    Square(Lines lines) {
        checkRectangle(lines);
        this.lines = lines;
    }

    private void checkRectangle(Lines lines) {
        for (int i = 0; i < lines.getLinesLength(); i += 2) {
            checkSameLength(lines, i);
        }
    }

    private void checkSameLength(Lines lines, int index) {
        if (lines.isNotEqual(index)) {
            throw new IllegalArgumentException("직사각형이나 정사각형이 아닙니다.");
        }
    }

    @Override
    public double getArea() {
        return lines.getLines().get(SQUARE_SECOND_LONGEST_LENGTH_INDEX)
                .multipleLength(lines.getLines().get(SQUARE_THIRD_LONGEST_LENGTH_INDEX));
    }

    @Override
    public String getResult() {
        return "사각형의 넓이는 %.2f 입니다.";
    }
}
