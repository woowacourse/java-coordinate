package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    private static final int NUMBER_OF_POINTS = 3;
    private final Points points;

    public Triangle(final Points points) {
        this.points = points;
        validateSize(this.points);
    }

    private void validateSize(final Points points) {
        if (points.size() != NUMBER_OF_POINTS) {
            throw new IllegalArgumentException("삼각형은 점이 3개 필요합니다.");
        }
    }

    public double area() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i+1; j < points.size(); j++) {
                lines.add(new Line(Points.of(Arrays.asList(points.get(i), points.get(j)))));
            }
        }
        double s = (lines.get(0).length() + lines.get(1).length() + lines.get(2).length()) / 2.0d;
        double x = (s * (s - lines.get(0).length()) * (s - lines.get(1).length()) * (s - lines.get(2).length()));
        double area = Math.sqrt(x);
        return area;
    }
}
