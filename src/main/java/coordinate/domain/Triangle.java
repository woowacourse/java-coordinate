package coordinate.domain;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Triangle {
    private static final int LINES_SIZE = 3;

    private final Lines lines;

    public Triangle(Lines lines) {
        validateNotNull(lines);
        validateNumOf(lines);
        this.lines = lines;
        validateTriangle(lines);
    }

    private void validateNumOf(Lines lines) {
        if (lines.getSize() != LINES_SIZE) {
            throw new IllegalArgumentException("삼각형은 3개의 라인을 가져야 합니다.");
        }
    }

    private void validateTriangle(Lines lines) {
        if (lines.isParallel(0,1)) {
            throw new IllegalArgumentException("삼각형에 평행한 라인이 존재해서는 안 됩니다.");
        }
    }

    public double area() {
        Vector v1 = lines.getVector(0);
        Vector v2 = lines.getVector(1);

        return Math.sqrt(Math.pow(v1.length(), 2) * Math.pow(v2.length(), 2) - Math.pow(v1.innerProduct(v2), 2)) / 2;
    }
}