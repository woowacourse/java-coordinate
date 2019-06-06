package coordinate.domain;

import coordinate.util.Vector;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertices {
    private List<Point> points;

    Vertices(List<Point> points) {
        validateDuplication(points);
        this.points = points;
    }

    private static void validateDuplication(List<Point> points) {
        Set<Point> nonDuplicatedPoints = new HashSet<>(points);
        if (nonDuplicatedPoints.size() != points.size()) {
            throw new IllegalArgumentException("중복된 좌표가 입력되었습니다.");
        }
    }

    Vector vector(int startPointIndex, int endPointIndex) {
        int deltaX = points.get(endPointIndex).minusX(points.get(startPointIndex));
        int deltaY = points.get(endPointIndex).minusY(points.get(startPointIndex));

        return new Vector(deltaX, deltaY);
    }

    int size() {
        return points.size();
    }

    List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    double integrateArea() {
        // 교차하지 않는 다각형에 대해서만 가능
        double area = 0;
        points.add(points.get(0));
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);

            area += linearlyIntegrateWithY(p1, p2);
        }
        points.remove(points.size() - 1);

        return Math.abs(area);
    }

    private double linearlyIntegrateWithY(Point p1, Point p2) {
        return (p1.getX() + p2.getX()) * (p1.getY() - p2.getY()) / 2;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < points.size(); i++) {
            stringBuilder.append("[")
                    .append(i)
                    .append("] (")
                    .append(points.get(i).getX())
                    .append(", ")
                    .append(points.get(i).getY())
                    .append(") \t");
        }
        return stringBuilder.toString();
    }
}
