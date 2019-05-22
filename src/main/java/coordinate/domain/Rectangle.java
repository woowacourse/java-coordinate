package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rectangle {
    private final static int START_POINT = 0;
    private final static int ONE_LINE = 1;

    private Map<Double, Integer> rectangleLines = new HashMap<>();

    public Rectangle(List<Point> points) {
        setRectangleLines(points);
        validateRectangle();
    }

    private void setRectangleLines(List<Point> points) {
        while (!points.isEmpty()) {
            setLinesFromOnePoint(points.remove(START_POINT), points);
        }
    }

    private void setLinesFromOnePoint(Point startPoint, List<Point> endPoints) {
        for (int endPointIndex = 0; endPointIndex < endPoints.size(); endPointIndex++) {
            double lineLength = new Line(startPoint, endPoints.get(endPointIndex)).getLength();
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
}
