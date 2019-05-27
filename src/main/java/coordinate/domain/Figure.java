package coordinate.domain;

import java.util.List;

public abstract class Figure implements Figureable {
    private static final int TRIANGLE_LINE_SIZE = 3;

    @Override
    public double area(List<Double> lineDistance) {
        double s = sumLineSegment(lineDistance) / 2;
        double area = s;
        for (int i = 0; i < TRIANGLE_LINE_SIZE; i++) {
            area *= s - lineDistance.get(i);
        }
        return Math.sqrt(area);
    }

    private double sumLineSegment(List<Double> lineDistance) {
        double sum = 0;
        for (int i = 0; i < TRIANGLE_LINE_SIZE; i++) {
            sum += lineDistance.get(i);
        }
        return sum;
    }

    @Override
    public void validateNumOf(Lines lines, int size) {
        if (lines.getSize() != size) {
            throw new IllegalArgumentException("해당 도형은 라인을 " + size + "만큼 가져야 합니다.");
        }
    }
}
