package calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class Triangle extends AbstractFigure {
    private static final String EX_NOT_TRIANGLE_MESSAGE = "삼각형이 될 수 없는 조건입니다.";
    private final Coordinates coordinates;

    public Triangle(FigureType figureType) {
        super(figureType);
        this.coordinates = getCoordinates();
        checkFigureCondition();
    }

    @Override
    void checkFigureCondition() {
        int TRI_LONGEST_SIDE = 2;
        int TRI_OTHER_SIDE = 1;
        int TRI_ANOTHER_SIDE = 0;

        List<Double> lengths = Arrays.asList(coordinates.get(0).straight(coordinates.get(1)),
                coordinates.get(1).straight(coordinates.get(2)),
                coordinates.get(0).straight(coordinates.get(2)));
        Collections.sort(lengths);
        checkNotFigure(lengths.get(TRI_LONGEST_SIDE) >= lengths.get(TRI_OTHER_SIDE) + lengths.get(TRI_ANOTHER_SIDE), EX_NOT_TRIANGLE_MESSAGE);
    }

    @Override
    public double perimeter() {
        return coordinates.get(0).straight(coordinates.get(1)) + coordinates.get(1).straight(coordinates.get(2)) + coordinates.get(0).straight(coordinates.get(2));
    }

    @Override
    public double area() {
        double powerLengthA = Math.pow(coordinates.get(0).straight(coordinates.get(1)), 2);
        double powerLengthB = Math.pow(coordinates.get(1).straight(coordinates.get(2)), 2);
        double powerLengthC = Math.pow(coordinates.get(0).straight(coordinates.get(2)), 2);
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