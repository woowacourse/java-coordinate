package coordinate.domain;

public class Triangle implements Figure {
    private static final int LONGEST_LENGTH_INDEX = 0;
    private static final int SECOND_LONGEST_LENGTH_INDEX = 1;
    private static final int THIRD_LONGEST_LENGTH_INDEX = 2;
    static final int POINT_NUMBER = 3;
    private Lines lines;

    Triangle(Lines lines) {
        if (isNotTriangle(lines)) {
            throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
        }
        this.lines = lines;
    }

    private boolean isNotTriangle(Lines lines) {
        return lines.getLines().get(LONGEST_LENGTH_INDEX).getLength() >=
                (lines.getLines().get(SECOND_LONGEST_LENGTH_INDEX)
                        .addLength(lines.getLines().get(THIRD_LONGEST_LENGTH_INDEX)));
    }

    @Override
    public double getArea() {
        double s = lines.getLines().get(LONGEST_LENGTH_INDEX)
                .addTwoLength(lines.getLines().get(SECOND_LONGEST_LENGTH_INDEX),
                        lines.getLines().get(THIRD_LONGEST_LENGTH_INDEX)) / 2;

        return Math.sqrt(s * (s - lines.getLines().get(LONGEST_LENGTH_INDEX).getLength())
                * (s - lines.getLines().get(SECOND_LONGEST_LENGTH_INDEX).getLength())
                * (s - lines.getLines().get(THIRD_LONGEST_LENGTH_INDEX).getLength()));
    }

    @Override
    public String getResult() {
        return "삼각형의 넓이는 %.2f 입니다.";
    }
}
