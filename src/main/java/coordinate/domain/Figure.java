package coordinate.domain;

import java.util.List;

public class Figure implements Shapeable {
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
}
