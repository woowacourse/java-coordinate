package coordinate.domain.shape;

import coordinate.domain.point.Point;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Triangle extends AbstractShape {
    private static final int MAX_LINE_INDEX = 2;
    private static final int HERON_FORMULA_NUMBER = 2;

    public Triangle(List<Point> points) {
        super(points);
        validateShape();
    }

    @Override
    public void validateShape() {
        Collections.sort(lines);
        double longestLine = lines.get(MAX_LINE_INDEX);
        double sumWithoutLongestLine = lines.stream()
                .filter(length -> !length.equals(longestLine))
                .mapToDouble(Double::doubleValue)
                .sum();
        if (longestLine >= sumWithoutLongestLine) {
            throw new IllegalArgumentException("올바른 삼각형을 입력해 주세요.");
        }
    }

    @Override
    public double area() {
        double heron = lines.stream()
                .mapToDouble(Double::doubleValue)
                .sum() / HERON_FORMULA_NUMBER;
        double area = heron;

        for (Double triangleLine : lines) {
            area *= (heron - triangleLine);
        }
        return Math.sqrt(area);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(lines, triangle.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "삼각형 넓이는 " + area();
    }
}
