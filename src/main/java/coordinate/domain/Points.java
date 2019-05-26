package coordinate.domain;

import java.util.*;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        isCorrectSize(points);
        this.points = checkDuplicate(points);
    }

    private void isCorrectSize(List<Point> points) {
        if (!(points.size() >= 2 && points.size() <= 4)) {
            throw new IllegalArgumentException("좌표는 2~4개 입력하세요");
        }
    }

    private List<Point> checkDuplicate(List<Point> points) {
        if (isDuplicate(points)) {
            throw new IllegalArgumentException("중복되지 않는 좌표를 입력해주세요.");
        }
        return points;
    }

    private boolean isDuplicate(List<Point> points) {
        HashSet<Point> set = new HashSet<>(points);
        return set.size() != points.size();
    }

    public boolean isContain(Point point) {
        return points.contains(point);
    }

    int getSize() {
        return this.points.size();
    }

    Point getPoint(int index) {
        return points.get(index);
    }

}
