package coordinate.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {
    private static final int START_POINT = 0;
    private static final int MAX_LINE_INDEX = 2;
    private static final int HERON_FORMULA_NUMBER = 2;

    private List<Double> triangleLines = new ArrayList<>();

    public Triangle(List<Point> points) {
        setTriangleLines(points);
        validateTriangle();
    }

    private void validateTriangle() {
        Collections.sort(triangleLines);
        double longestLine = triangleLines.get(MAX_LINE_INDEX);
        double sumWithoutLongestLine = triangleLines.stream()
                .filter(length -> !length.equals(triangleLines.get(MAX_LINE_INDEX)))
                .mapToDouble(Double::doubleValue).sum();

        if (longestLine >= sumWithoutLongestLine) {
            throw new IllegalArgumentException("올바른 삼각형을 입력해 주세요.");
        }
    }

    private void setTriangleLines(List<Point> points) {
        while (!points.isEmpty()) {
            setLinesFromOnePoint(points.remove(START_POINT), points);
        }
    }

    private void setLinesFromOnePoint(Point startPoint, List<Point> endPoints) {
        for (Point endPoint : endPoints) {
            double lineLength = new Line(startPoint, endPoint).getLength();
            triangleLines.add(lineLength);
        }
    }

    public double getArea() {
        double heron = triangleLines.stream()
                .mapToDouble(Double::doubleValue)
                .sum() / HERON_FORMULA_NUMBER;
        double area = heron;

        for (Double triangleLine : triangleLines) {
            area *= (heron - triangleLine);
        }
        return Math.sqrt(area);
    }
}
