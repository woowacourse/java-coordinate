package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rectangle extends PlaneFigure {
    private final Lines lines;

    public Rectangle(List<Coordinate> coordinates) {
        super(coordinates);
        Lines lines = new Lines(this.coordinates);
        checkValidRectangle(lines);
        this.lines = lines;
    }

    private void checkValidRectangle(Lines lines) {
        if (!canMakeRectangle(lines)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean canMakeRectangle(Lines lines) {
        Map<Double, Long> lineLengthCountMap = lines.getLines().stream()
                .collect(Collectors.groupingBy(Line::calculateArea, Collectors.counting()));

        return lineLengthCountMap.values().stream().allMatch(i -> i % 2 == 0);
    }

    @Override
    public double calculateArea() {
        Line a = lines.get(0);
        Line b = lines.get(2);
        return LineCalculator.multipleLength(a, b);
    }

    @Override
    public String resultMessage() {
        return "사각형의 넓이는 : ";
    }
}
