package coordinate.domain;

import java.util.HashSet;
import java.util.List;

public class Figure {
    static final int BASE = 0;

    void validateDuplicate(List<Point> points) {
        if (points.size() != (new HashSet<>(points)).size()) {
            throw new IllegalArgumentException("같은 점은 입력할 수 없습니다.");
        }
    }

    void validateSizeOf(List<Point> points, int numberOfPoint) {
        if (points.size() != numberOfPoint) {
            throw new IllegalArgumentException("점의 갯수가 " + numberOfPoint + " 개여야 합니다.");
        }
    }
}
