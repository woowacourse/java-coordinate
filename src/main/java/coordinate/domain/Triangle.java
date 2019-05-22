package coordinate.domain;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Triangle {
    private static final int LINES_SIZE = 3;
    private static final int COMPARE_SLOPE = 0;

    private final Lines lines;

    public Triangle(Lines lines) {
        validateNotNull(lines);
        validateNumOf(lines);
        this.lines = lines;
        validateFigure();
    }

    private void validateNumOf(Lines lines) {
        if (lines.getSize() != LINES_SIZE) {
            throw new IllegalArgumentException("삼각형은 3개의 라인을 가져야 합니다.");
        }
    }

    private void validateFigure() {
        if (checkSameSlope()) {
            throw new IllegalArgumentException("같은 선 상의 있는 3개의 점은 삼각형을 만들 수 없습니다.");
        }
    }

    private boolean checkSameSlope() {
        return Double.compare(lines.getLine(0).calculateSlope()
                , lines.getLine(1).calculateSlope()) == COMPARE_SLOPE;
    }
}