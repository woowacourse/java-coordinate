package calculator.domain;

import java.util.*;

/**
 * @author soojinroh
 * @version 1.0 2019-05-23
 */
public class Rectangle extends Figure{

    private static final String EX_NOT_RECTANGLE_MESSAGE = "x축, y축과 평행한 직사각형이 아닙니다.";
    private final Coordinates coordinates;

    public Rectangle(Coordinates coordinates) {
        super("사각형", "넓이");
        this.coordinates = coordinates;
        checkRectangle();
    }

    private void checkRectangle() {
        Set<Integer> xCoordinates = new HashSet<>();
        Set<Integer> yCoordinates = new HashSet<>();

        for (int i = 0; i < coordinates.size(); i++) {
            xCoordinates.add(coordinates.get(i).getXCoordinate());
            yCoordinates.add(coordinates.get(i).getYCoordinate());
        }

        checkNotRectangle(xCoordinates, yCoordinates);
    }

    private void checkNotRectangle(Set<Integer> xCoordinates, Set<Integer> yCoordinates) {
        if (!(xCoordinates.size() == 2 && yCoordinates.size() == 2)) {
            throw new IllegalArgumentException(EX_NOT_RECTANGLE_MESSAGE);
        }
    }

    public double straight(Set<Integer> axisCoordinates) {
        Iterator<Integer> iterator = axisCoordinates.iterator();
        List<Integer> coordinates = new ArrayList<>();
        while (iterator.hasNext()) {
            coordinates.add(iterator.next());
        }

        return Math.abs(coordinates.get(0) - coordinates.get(1));
    }

    @Override
    public double area() {
        Set<Integer> xCoordinates = new HashSet<>();
        Set<Integer> yCoordinates = new HashSet<>();

        for (int i = 0; i < coordinates.size(); i++) {
            xCoordinates.add(coordinates.get(i).getXCoordinate());
            yCoordinates.add(coordinates.get(i).getYCoordinate());
        }

        return straight(xCoordinates) * straight(yCoordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(coordinates, rectangle.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
