package calculator.domain;

import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class Triangle extends Figure {

    private final Coordinates coordinates;

    public Triangle(Coordinates coordinates) {
        super("삼각형", "넓이");
        this.coordinates = coordinates;
    }

    @Override
    public double area() {
        double powerLengthA = Math.pow(straight(coordinates.get(0), coordinates.get(1)), 2);
        double powerLengthB = Math.pow(straight(coordinates.get(1), coordinates.get(2)), 2);
        double powerLengthC = Math.pow(straight(coordinates.get(0), coordinates.get(2)), 2);

        return Math.sqrt(4 * powerLengthA * powerLengthB - Math.pow(powerLengthA + powerLengthB - powerLengthC, 2)) / 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(coordinates, triangle.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }

}