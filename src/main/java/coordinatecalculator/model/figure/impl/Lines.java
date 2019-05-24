package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(Coordinates coordinates) {
        List<Line> lines = toLines(coordinates);
        checkThreeCoordinatesInLine(lines);
        Collections.sort(lines);
        this.lines = lines;
    }

    private void checkThreeCoordinatesInLine(List<Line> lines) {
        Map<Double, Long> lineLengthCountMap = lines.stream()
                .collect(Collectors.groupingBy(Line::calculateGradient, Collectors.counting()));

        if (isThreeCoordinatesInLine(lineLengthCountMap)) {
            throw new IllegalArgumentException("세 좌표가 한 직선 위에 있습니다.");
        }
    }

    private List<Line> toLines(Coordinates coordinates) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0, length = coordinates.size(); i < length - 1; i++) {
            matchUnmetCoordinates(lines, coordinates, i);
        }
        return lines;
    }

    private void matchUnmetCoordinates(List<Line> lines, Coordinates coordinates, int coordinateIndex) {
        for (int j = coordinateIndex + 1, length = coordinates.size(); j < length; j++) {
            lines.add(new Line(Arrays.asList(coordinates.get(coordinateIndex), coordinates.get(j))));
        }
    }

    boolean canMakeRectangle() {
        Map<Double, Long> lineLengthCountMap = lines.stream()
                .collect(Collectors.groupingBy(Line::calculateArea, Collectors.counting()));

        return lineLengthCountMap.values().stream().allMatch(this::isEvenNumber);
    }

    private boolean isEvenNumber(Long number) {
        return number % 2 == 0;
    }

    private boolean isThreeCoordinatesInLine(Map<Double, Long> lineLengthCountMap) {
        return lineLengthCountMap.values().stream().anyMatch(i -> i >= 3);
    }

    Line get(int index) {
        return lines.get(index);
    }
}
