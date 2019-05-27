package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rectangle extends PlaneFigure {
    private static final String PRE_MESSAGE = "사각형의 넓이는 : ";
    private static final int FIRST_COORDINATE = 0;
    private static final int SECOND_COORDINATE = 1;
    private static final int THIRD_COORDINATE = 2;

    public Rectangle(List<Coordinate> coordinates) {
        super(coordinates);
        checkValidRectangle(coordinates);
    }

    private void checkValidRectangle(List<Coordinate> coordinates) {
        if (!canMakeRectangle(this.coordinates.toLines(coordinates))) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    boolean canMakeRectangle(List<Line> lines) {
        Map<Double, Long> lineLengthCountMap = lines.stream()
                .collect(Collectors.groupingBy(Line::calculateArea, Collectors.counting()));

        return lineLengthCountMap.values().stream().allMatch(this::isEvenNumber);
    }

    private boolean isEvenNumber(Long number) {
        return number % 2 == 0;
    }

    @Override
    public double calculateArea() {
        double width = new Line(Arrays.asList(coordinates.get(FIRST_COORDINATE), coordinates.get(SECOND_COORDINATE))).calculateArea();
        double height = new Line(Arrays.asList(coordinates.get(FIRST_COORDINATE), coordinates.get(THIRD_COORDINATE))).calculateArea();
        return width * height;
    }

    @Override
    public String getPreMessage() {
        return PRE_MESSAGE;
    }
}
