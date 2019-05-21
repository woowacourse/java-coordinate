package coordinate;

import static util.NotNullValidator.validateNotNull;

public class Triangle {
    private static final int POINTS_SIZE = 3;

    private final Lines lines;

    public Triangle(Lines lines) {
        validateNotNull(lines);
        validateNumOf(lines);
        this.lines = lines;
    }

    private void validateNumOf(Lines lines) {
        if (lines.getSize() != POINTS_SIZE) {
            throw new IllegalArgumentException("삼각형은 3개의 점을 가져야 합니다.");
        }
    }

    public boolean checkSameSlope() {
        return Double.compare(lines.getLine(0).calculateSlope()
                , lines.getLine(1).calculateSlope()) == 0;
    }

    public double area() {
        double sum = 0;
        for (int i = 0; i < POINTS_SIZE; i++) {
            sum += lines.getLine(i).calculateDistance();
        }
        double s = sum / 2;
        double area = s;
        for (int i = 0; i < POINTS_SIZE; i++) {
            area *= s - lines.getLine(i).calculateDistance();
            s = sum / 2;
        }
        return Math.sqrt(area);
    }
}