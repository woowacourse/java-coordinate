package coordinate.model;

import coordinate.util.HeronFormula;

import java.util.Collections;
import java.util.List;

public class Triangle {
    List<Point> points;

    public Triangle(List<Point> points) {
        checkDuplication(points);
        checkIsLine(points);
        this.points = points;
    }

    private void checkIsLine(List<Point> points) {
        Collections.sort(points);
        if (points.get(0).getIncline(points.get(1))
                == points.get(1).getIncline(points.get(2))) {
            throw new IllegalArgumentException("세 점이 한 직선에 있으면 안됩니다.");
        }
    }

    private void checkDuplication(List<Point> points) {
        Collections.sort(points);
        for (int i = 0; i < points.size() - 1; i++) {
            checkDuplicationOnePoint(points, i);
        }
    }

    private void checkDuplicationOnePoint(List<Point> points, int i) {
        if (points.get(i).equals(points.get(i + 1))) {
            throw new IllegalArgumentException("중복 좌표 오류");
        }
    }

    public double getArea() {
        double a = points.get(0).getDistance(points.get(1));
        double b = points.get(0).getDistance(points.get(2));
        double c = points.get(1).getDistance(points.get(2));
        return HeronFormula.getTriangleArea(a, b, c);
    }
}
