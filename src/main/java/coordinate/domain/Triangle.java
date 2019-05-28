package coordinate.domain;

import java.util.*;

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
                .filter(length -> !length.equals(lines.get(MAX_LINE_INDEX)))
                .mapToDouble(Double::doubleValue)
                .sum();
        if (longestLine >= sumWithoutLongestLine) {
            throw new IllegalArgumentException("올바른 삼각형을 입력해 주세요.");
        }
    }

//    private void setTriangleLines(List<Point> points) {
//        while (!points.isEmpty()) {
//            setLinesFromOnePoint(points.remove(START_POINT), points);
//        }
//    }
//
//    private void setLinesFromOnePoint(Point startPoint, List<Point> endPoints) {
//        for (Point endPoint : endPoints) {
//            double lineLength = new Line(Arrays.asList(startPoint, endPoint)).area();
//            triangleLines.add(lineLength);
//        }
//    }

//    private void validateTriangle() {
//        Collections.sort(triangleLines);
//        double longestLine = triangleLines.get(MAX_LINE_INDEX);
//        double sumWithoutLongestLine = triangleLines.stream()
//                .filter(length -> !length.equals(triangleLines.get(MAX_LINE_INDEX)))
//                .mapToDouble(Double::doubleValue).sum();
//
//        if (longestLine >= sumWithoutLongestLine) {
//            throw new IllegalArgumentException("올바른 삼각형을 입력해 주세요.");
//        }
//    }

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
