package coordinate.domain.shape;

import coordinate.domain.point.Point;

import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Rectangle extends AbstractShape {
    private static final int ONE_LINE = 1;
    private static final int PAIR_LINE_COUNT = 2;
    private static final int DEFAULT_AREA = 1;

    private TreeMap<Double, Integer> rectangleLines = new TreeMap<>();

    public Rectangle(List<Point> points) {
        super(points);
        initializeRectangleLines();
        validateShape();
    }

    private void initializeRectangleLines() {
        for (Double lineLength : lines) {
            addLine(lineLength);
        }
    }

    private void addLine(Double lineLength) {
        if (rectangleLines.containsKey(lineLength)) {
            rectangleLines.put(lineLength, rectangleLines.get(lineLength) + ONE_LINE);
            return;
        }
        rectangleLines.put(lineLength, ONE_LINE);
    }

    @Override
    public void validateShape() {
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

    @Override
    public String toString() {
        return "사각형 넓이는 " + area();
    }
}
