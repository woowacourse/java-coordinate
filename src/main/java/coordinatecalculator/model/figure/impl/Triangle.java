package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.List;

public class Triangle extends PlaneFigure {
    private final Lines lines;

    public Triangle(List<Coordinate> coordinates) {
        super(coordinates);
        this.lines = new Lines(this.coordinates);
    }

    @Override
    public double calculateArea() {
        Line a = lines.get(0);
        Line b = lines.get(1);
        Line c = lines.get(2);

        return LineCalculator.triangleArea(a, b, c);
    }

    @Override
    public String resultMessage() {
        return "삼각형의 넓이는 : ";
    }
}
