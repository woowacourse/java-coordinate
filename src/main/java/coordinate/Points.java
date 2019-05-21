package coordinate;

import java.util.List;

public class Points {

    private final List<Point> points;

    public Points(List<Point> points) {
        validateNotNull(points);
        this.points = points;
    }

    private void validateNotNull(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("생성자의 인자에 null이 입력될 수 없습니다.");
        }
    }

    public Point get(int index) {
        validateIndex(index);
        return points.get(index);
    }

    private void validateIndex(int index) {
        if (index >= points.size() || index < 0) {
            throw new IllegalArgumentException("리스트 인덱스가 적절하지 않습니다.");
        }
    }
}
