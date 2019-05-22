package coordinate.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        checkDuplicateCoordinate(points);
        Collections.sort(points);
        this.points = points;
    }

    private void checkDuplicateCoordinate(List<Point> points) {
        Set<Point> set = new HashSet<>(points);
        if (set.size() != points.size()) {
            throw new IllegalArgumentException("중복된 좌표는 허용하지 않습니다.");
        }
    }

    public List<Integer> getXCoordinates() {
        return points.stream()
                .map(Point::getX)
                .collect(Collectors.toList());
    }

    public List<Integer> getYCoordinates() {
        return points.stream()
                .map(Point::getY)
                .collect(Collectors.toList());
    }

    public int getMinX(){
        return points.get(0).getX();
    }

    public int getMinY(){
        return points.get(0).getY();
    }

    public int getMaxX(){
        return points.get(points.size() - 1).getX();
    }

    public int getMaxY(){
        return points.get(points.size() - 1).getY();
    }
}
