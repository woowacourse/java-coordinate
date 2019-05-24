package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.List;

public class Rectangle extends PlaneFigure {
    private static final String PRE_MESSAGE = "사각형의 넓이는 : ";
    private final Lines lines;

    public Rectangle(List<Coordinate> coordinates) {
        super(coordinates);
        Lines lines = new Lines(this.coordinates);
        checkValidRectangle(lines);
        this.lines = lines;
    }

    private void checkValidRectangle(Lines lines) {
        if (!lines.canMakeRectangle()) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    @Override
    public double calculateArea() {
        double side1 = lines.get(0).calculateArea();
        double side2 = lines.get(2).calculateArea();
        return side1 * side2;
    }

    @Override
    public String getPreMessage() {
        return PRE_MESSAGE;
    }
}
