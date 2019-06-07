package coordinate.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Figure {
    private static final int SQUARE = 2;

    private List<Point> points;

    Figure(List<Point> points, int figurePointsSize) {
        validateDuplicate(points);
        validateSizeOf(points, figurePointsSize);
        this.points = Collections.unmodifiableList(points);
    }

    private void validateSizeOf(List<Point> points, int figurePointsSize) {
        if (points.size() != figurePointsSize) {
            throw new IllegalArgumentException("점의 갯수가 " + figurePointsSize + " 개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Point> points) {
        if (points.size() != (new HashSet<>(points)).size()) {
            throw new IllegalArgumentException("같은 점은 입력할 수 없습니다.");
        }
    }

    public int getNumOfPoints() {
        return points.size();
    }

    List<Point> findXPairs(int index) {
        return points.stream().filter(p -> p.matchX(points.get(index))).collect(Collectors.toList());
    }

    List<Point> findYPairs(int index) {
        return points.stream().filter(p -> p.matchY(points.get(index))).collect(Collectors.toList());
    }

    double calculateLength(int startIndex, int endIndex) {
        return Math.sqrt(Math.pow(calculateDeltaX(startIndex, endIndex), SQUARE)
                + Math.pow(calculateDeltaY(startIndex, endIndex), SQUARE));
    }

    private int calculateDeltaX(int startIndex, int endIndex) {
        return points.get(startIndex).getDeltaXTo(points.get(endIndex));
    }

    private int calculateDeltaY(int startIndex, int endIndex) {
        return points.get(startIndex).getDeltaYTo(points.get(endIndex));
    }

    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < points.size();
            }

            @Override
            public Point next() {
                return points.get(count++);
            }
        };
    }

    public abstract double calculateAttribute();
}