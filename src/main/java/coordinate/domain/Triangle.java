package coordinate.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangle {
    private static final int NUM_OF_POINT = 3;
    private static final int BASE = 0;
    private static final int UNIQUE_SIZE = 1;

    private List<Point> points;

    public Triangle(List<Point> points) {
        validateDuplicate(points);
        validateSizeOf(points);
        validateTriangle(points);
        this.points = points;
    }

    private void validateTriangle(List<Point> points) {
        Set<Double> slopes = new HashSet<>();
        Point basePoint = points.get(BASE);

        for (int i = 1; i < points.size(); i++) {
            slopes.add((new StraightLine(Arrays.asList(basePoint, points.get(i)))).calculateSlope());
        }

        if (slopes.size() == UNIQUE_SIZE) {
            throw new IllegalArgumentException("한 직선에 세 개의 점이 있을 수 없습니다.");
        }
    }

    private void validateDuplicate(List<Point> points) {
        if (points.size() != (new HashSet<>(points)).size()) {
            throw new IllegalArgumentException("같은 점은 입력할 수 없습니다.");
        }
    }

    private void validateSizeOf(List<Point> points) {
        if (points.size() != NUM_OF_POINT) {
            throw new IllegalArgumentException("점의 갯수가 세개여야 합니다.");
        }
    }
}
