package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author soojinroh
 * @version 1.0 2019-05-23
 */
public class Triangle extends Figure {

    private static final String EX_NOT_TRIANGLE_MESSAGE = "삼각형이 될 수 없는 조건입니다.";
    private static final int TRI_LONGEST_SIDE = 2;
    private static final int TRI_OTHER_SIDE = 1;
    private static final int TRI_ANOTHER_SIDE = 0;
    private final Coordinates coordinates;

    public Triangle(Coordinates coordinates) {
        super("삼각형", "넓이");
        this.coordinates = coordinates;
        checkTriangle();
    }

    private void checkTriangle() {
        double lengthA = straight(coordinates.get(0), coordinates.get(1));
        double lengthB = straight(coordinates.get(1), coordinates.get(2));
        double lengthC = straight(coordinates.get(0), coordinates.get(2));

        List<Double> lengths = Arrays.asList(lengthA, lengthB, lengthC);
        Collections.sort(lengths);
        checkNotTriangle(lengths);
    }

    private void checkNotTriangle(List<Double> lengths) {
        if (lengths.get(TRI_LONGEST_SIDE) >= lengths.get(TRI_OTHER_SIDE) + lengths.get(TRI_ANOTHER_SIDE)) {
            throw new IllegalArgumentException(EX_NOT_TRIANGLE_MESSAGE);
        }
    }

    @Override
    public double area() {
        double powerLengthA = Math.pow(straight(coordinates.get(0), coordinates.get(1)), 2);
        double powerLengthB = Math.pow(straight(coordinates.get(1), coordinates.get(2)), 2);
        double powerLengthC = Math.pow(straight(coordinates.get(0), coordinates.get(2)), 2);
        double triangleArea = Math.sqrt(4 * powerLengthA * powerLengthB - Math.pow(powerLengthA + powerLengthB - powerLengthC, 2)) / 4;
        return triangleArea;
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