package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.Arrays;
import java.util.List;

public class Triangle extends PlaneFigure {
    private static final String PRE_MESSAGE = "삼각형의 넓이는 : ";
    private static final int FIRST_COORDINATE = 0;
    private static final int SECOND_COORDINATE = 1;
    private static final int THIRD_COORDINATE = 2;
    private static final int SQUARE = 2;

    public Triangle(List<Coordinate> coordinates) {
        super(coordinates);
    }

    /**
     * @desc : Heron's Formula
     */
    @Override
    public double calculateArea() {
        double a = new Line(Arrays.asList(coordinates.get(FIRST_COORDINATE), coordinates.get(SECOND_COORDINATE))).calculateArea();
        double b = new Line(Arrays.asList(coordinates.get(FIRST_COORDINATE), coordinates.get(THIRD_COORDINATE))).calculateArea();
        double c = new Line(Arrays.asList(coordinates.get(SECOND_COORDINATE), coordinates.get(THIRD_COORDINATE))).calculateArea();
        double squaredA = Math.pow(a, SQUARE);
        double squaredB = Math.pow(b, SQUARE);
        double squaredC = Math.pow(c, SQUARE);

        return (double) 1 / 4 * Math.sqrt(4 * squaredA * squaredB
                - Math.pow(squaredA + squaredB - squaredC, SQUARE));
    }

    @Override
    public String getPreMessage() {
        return PRE_MESSAGE;
    }
}
