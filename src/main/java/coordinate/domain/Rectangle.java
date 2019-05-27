package coordinate.domain;

import java.util.*;

public class Rectangle extends AbstractShape {
    static final int SIZE_OF_POINTS_FOR_RECTANGLE = 4;
    private static final int START_POINT = 0;
    private static final int ONE_LINE = 1;
    private static final int PAIR_LINE_COUNT = 2;
    private static final int DEFAULT_AREA = 1;

    private TreeMap<Double, Integer> rectangleLines = new TreeMap<>();

    public Rectangle(List<Point> points) {
        super(points);
        List<Point> copiedPoints = new ArrayList<>(points);
        setRectangleLines(copiedPoints);
        validateRectangle();
    }

    private void setRectangleLines(List<Point> points) {
        while (!points.isEmpty()) {
            setLinesFromOnePoint(points.remove(START_POINT), points);
        }
    }

    private void setLinesFromOnePoint(Point startPoint, List<Point> endPoints) {
        for (Point endPoint : endPoints) {
            double lineLength = new Line(Arrays.asList(startPoint, endPoint)).area();
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
    public int size() {
        return SIZE_OF_POINTS_FOR_RECTANGLE;
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

    @Override
    public String toString() {
        return "사각형 넓이는 " + area();
    }
}
