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
    private static final int LONGEST_SIDE_OF_TRIANGLE = 2;
    private static final int TRI_OTHER_SIDE = 1;
    private static final int TRI_ANOTHER_SIDE = 0;
    private final Coordinates coordinates;
    private final double ASideOfTriangle;
    private final double BSideOfTriangle;
    private final double CSideOfTriangle;

    public Triangle(Coordinates coordinates) {
        super("삼각형", "넓이");
        this.coordinates = coordinates;
        checkTriangle();

        ASideOfTriangle = straight(coordinates.get(0), coordinates.get(1));
        BSideOfTriangle = straight(coordinates.get(1), coordinates.get(2));
        CSideOfTriangle = straight(coordinates.get(0), coordinates.get(2));
    }

    private void checkTriangle() {
        List<Double> lengths = Arrays.asList(ASideOfTriangle, BSideOfTriangle, CSideOfTriangle);
        Collections.sort(lengths);
        checkNotTriangle(lengths);
    }

    private void checkNotTriangle(List<Double> lengths) {
        if (lengths.get(LONGEST_SIDE_OF_TRIANGLE) >= lengths.get(TRI_OTHER_SIDE) + lengths.get(TRI_ANOTHER_SIDE)) {
            throw new IllegalArgumentException(EX_NOT_TRIANGLE_MESSAGE);
        }
    }

    @Override
    public double area() {
        double powerLengthA = Math.pow(ASideOfTriangle, 2);
        double powerLengthB = Math.pow(BSideOfTriangle, 2);
        double powerLengthC = Math.pow(CSideOfTriangle, 2);
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