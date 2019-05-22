package coordinate.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle {
    private final Points points;

    public Rectangle(Points points) {
        checkValidCoordinate(points.getXCoordinates());
        checkValidCoordinate(points.getYCoordinates());
        this.points = points;
    }

    public void checkValidCoordinate(List<Integer> coordinates) {
        long count = coordinates.stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .values()
                .stream()
                .filter(groupedCoordinate -> groupedCoordinate.size() == 2)
                .count();

        if (count != 2) {
            throw new IllegalArgumentException("직사각형만 가능합니다.");
        }
    }

    public double area() {
        return (points.getMaxX() - points.getMinX()) * (points.getMaxY() - points.getMinY());
    }
}
