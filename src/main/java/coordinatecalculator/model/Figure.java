package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Figure {
    protected List<Line> lines;

    protected Figure(List<Coordinate> coordinates) {
        checkSameCoordinate(coordinates);
        List<Line> lines = getLines(coordinates);
        checkThreeCoordinatesInLine(lines);

        this.lines = lines;
    }

    private void checkSameCoordinate(List<Coordinate> coordinates) {
        if (coordinates.size() != new HashSet<>(coordinates).size()) {
            throw new IllegalArgumentException("겹치는 좌표가 있습니다.");
        }
    }

    private void checkThreeCoordinatesInLine(List<Line> lines) {
        Map<Double, Long> lineLengthCountMap = lines.stream()
                .collect(Collectors.groupingBy(Line::getGradient, Collectors.counting()));

        if (lineLengthCountMap.values().stream().anyMatch(i -> i >= 3)) {
            throw new IllegalArgumentException("세 좌표가 한 직선 위에 있습니다.");
        }
    }

    abstract double calculateArea();

    private List<Line> getLines(List<Coordinate> coordinates) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < coordinates.size() - 1; i++) {
            matchUnmetCoordinates(lines, coordinates, i);
        }
        return lines;
    }

    private void matchUnmetCoordinates(List<Line> lines, List<Coordinate> coordinates, int coordinateIndex) {
        for (int j = coordinateIndex + 1; j < coordinates.size(); j++) {
            lines.add(new Line(coordinates.get(coordinateIndex), coordinates.get(j)));
        }
    }
}
