package calculator.domain.figure;

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
    private static final int OTHER_SIDE_OF_TRIANGLE = 1;
    private static final int ANOTHER_SIDE_OF_TRIANGLE = 0;
    private final double ASideOfTriangle;
    private final double BSideOfTriangle;
    private final double CSideOfTriangle;

    private final Coordinates coordinates;

    public Triangle(Coordinates coordinates) {
        this.coordinates = coordinates;

        ASideOfTriangle = straight(coordinates.get(0), coordinates.get(1));
        BSideOfTriangle = straight(coordinates.get(1), coordinates.get(2));
        CSideOfTriangle = straight(coordinates.get(0), coordinates.get(2));

        checkTriangle();
    }

    private void checkTriangle() {
        List<Double> lengths = Arrays.asList(ASideOfTriangle, BSideOfTriangle, CSideOfTriangle);
        Collections.sort(lengths);
        checkNotTriangle(lengths);
    }

    private void checkNotTriangle(List<Double> lengths) {
        if (lengths.get(LONGEST_SIDE_OF_TRIANGLE) >= lengths.get(OTHER_SIDE_OF_TRIANGLE) + lengths.get(ANOTHER_SIDE_OF_TRIANGLE)) {
            throw new IllegalArgumentException(EX_NOT_TRIANGLE_MESSAGE);
        }
    }

    @Override
    public double area() {
        double squaredASideOfTriangle = Math.pow(ASideOfTriangle, 2);
        double squaredBSideOfTriangle = Math.pow(BSideOfTriangle, 2);
        double suqaredCSideOfTriangle = Math.pow(CSideOfTriangle, 2);
        return Math.sqrt(4 * squaredASideOfTriangle * squaredBSideOfTriangle - Math.pow(squaredASideOfTriangle + squaredBSideOfTriangle - suqaredCSideOfTriangle, 2)) / 4;
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