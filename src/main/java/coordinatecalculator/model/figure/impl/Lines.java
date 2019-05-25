package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinates;

import java.util.*;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(Coordinates coordinates){
        List<Line> lines = generateLines(coordinates);
        checkThreeCoordinatesInLine(lines);
        Collections.sort(lines);
        this.lines = lines;
    }

    private void checkThreeCoordinatesInLine(List<Line> lines) {
        Map<Double, Long> lineLengthCountMap = lines.stream()
                .collect(Collectors.groupingBy(Line::calculateGradient, Collectors.counting()));

        if (lineLengthCountMap.values().stream().anyMatch(i -> i >= 3)) {
            throw new IllegalArgumentException("세 좌표가 한 직선 위에 있습니다.");
        }
    }

    private List<Line> generateLines(Coordinates coordinates) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < coordinates.size() - 1; i++) {
            matchUnmetCoordinates(lines, coordinates, i);
        }
        return lines;
    }

    private void matchUnmetCoordinates(List<Line> lines, Coordinates coordinates, int coordinateIndex) {
        for (int j = coordinateIndex + 1; j < coordinates.size(); j++) {
            lines.add(new Line(Arrays.asList(coordinates.get(coordinateIndex), coordinates.get(j))));
        }
    }

    public boolean canMakeRectangle() {
        Map<Double, Long> lineLengthCountMap = lines.stream()
            .collect(Collectors.groupingBy(Line::calculateArea, Collectors.counting()));

        return lineLengthCountMap.values().stream().allMatch(i -> i % 2 == 0);
    }

    public Line get(int index){
        return lines.get(index);
    }
}
