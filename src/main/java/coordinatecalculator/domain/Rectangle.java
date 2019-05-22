package coordinatecalculator.domain;

import java.util.Collections;
import java.util.List;

public class Rectangle {
    private final List<Coordinate> coordinates;

    public Rectangle(List<Coordinate> coordinates) {
        Collections.sort(coordinates);
        isValidRectangle(coordinates);

        this.coordinates = coordinates;
    }

    private void isValidRectangle(List<Coordinate> coordinates) {
        int vertical = (int) Math.pow(coordinates.get(0).calculate(coordinates.get(1)), 2);
        int horizontal = (int) Math.pow(coordinates.get(0).calculate(coordinates.get(2)), 2);
        int diagonal = (int) Math.pow(coordinates.get(1).calculate(coordinates.get(2)), 2);
        checkPythagoras(vertical, horizontal, diagonal);

        vertical = (int) Math.pow(coordinates.get(2).calculate(coordinates.get(3)), 2);
        horizontal = (int) Math.pow(coordinates.get(1).calculate(coordinates.get(3)), 2);
        checkPythagoras(vertical, horizontal, diagonal);
    }

    private void checkPythagoras(final int vertical, final int horizontal, final int diagonal) {
        if ((vertical + horizontal) != diagonal) {
            throw new IllegalArgumentException("직사각형이 아닙니다!!");
        }
    }

    public double area() {
        return coordinates.get(0).calculate(coordinates.get(1)) * coordinates.get(0).calculate(coordinates.get(2));
    }
}
