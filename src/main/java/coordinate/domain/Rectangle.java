package coordinate.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle extends Figure{
    public Rectangle(Points points) {
        super("사각형의 넓이는 : ", points);
        checkValidCoordinate(points.getXCoordinates());
        checkValidCoordinate(points.getYCoordinates());
        this.points = points;
    }

    private void checkValidCoordinate(List<Integer> coordinates) {
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

    @Override
    public double calculateResult() {
        double height = points.getPoints(0).calculateDistance(points.getPoints(1));
        double width = points.getPoints(0).calculateDistance(points.getPoints(2));
        return height * width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
