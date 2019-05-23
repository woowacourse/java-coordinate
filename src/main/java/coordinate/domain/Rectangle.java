package coordinate.domain;

import java.util.*;

public class Rectangle extends Shape{
    private final static int START_POINT = 0;
    private final static int ONE_LINE = 1;
    private final static int PAIR_LINE_COUNT = 2;
    private final static int DEFAULT_AREA = 1;

    private TreeMap<Double, Integer> rectangleLines = new TreeMap<>();

    @Override
    public Shape setShape(List<Point> points) {
        setRectangleLines(points);
        validateRectangle();
        return this;
    }

    private void setRectangleLines(List<Point> points) {
        while (!points.isEmpty()) {
            setLinesFromOnePoint(points.remove(START_POINT), points);
        }
    }

    private void setLinesFromOnePoint(Point startPoint, List<Point> endPoints) {
        for (Point endPoint : endPoints) {
            double lineLength = new Line().setShape(Arrays.asList(startPoint, endPoint)).area();
            addLine(lineLength);
        }
    }

    private void addLine(double lineLength) {
        if (rectangleLines.containsKey(lineLength)) {
            rectangleLines.put(lineLength, rectangleLines.get(lineLength) + ONE_LINE);
            return;
        }
        rectangleLines.put(lineLength, ONE_LINE);
    }

    private void validateRectangle() {
        for (Double line : rectangleLines.keySet()) {
            checkPairOf(line);
        }
    }

    private void checkPairOf(Double line) {
        if (!isPaired(line)) {
            throw new IllegalArgumentException("올바른 사각형을 입력해 주세요.");
        }
    }

    private boolean isPaired(Double line) {
        return rectangleLines.get(line) % 2 == 0;
    }

    @Override
    public double area() {
        double area = DEFAULT_AREA;

        removeDiagonal();
        for (Double line : rectangleLines.keySet()) {
            area *= Math.pow(line, (rectangleLines.get(line) / PAIR_LINE_COUNT));
        }
        return area;
    }

    private void removeDiagonal() {
        rectangleLines.pollLastEntry();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(rectangleLines, rectangle.rectangleLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rectangleLines);
    }
}
