package coordinatecalculator.model.coordinate;

import coordinatecalculator.model.figure.impl.Line;

import java.util.*;
import java.util.stream.Collectors;

public class Coordinates {
    private final List<Coordinate> coordinates;
    private final int POLYGON_COORDINATES = 3;

    public Coordinates(List<Coordinate> coordinates) {
        checkValidCoordinates(coordinates);
        Collections.sort(coordinates);
        this.coordinates = coordinates;
    }

    private void checkValidCoordinates(List<Coordinate> coordinates) {
        if (isDuplicatedCoordinates(coordinates)) {
            throw new IllegalArgumentException("겹치는 좌표가 있습니다.");
        }
        if (coordinates.size() >= POLYGON_COORDINATES && isThreeCoordinatesInLine(coordinates)) {
            throw new IllegalArgumentException("세 점이 같은 직선 위에 있습니다.");
        }
    }

    private boolean isDuplicatedCoordinates(List<Coordinate> coordinates) {
        return coordinates.size() != new HashSet<>(coordinates).size();
    }

    private boolean isThreeCoordinatesInLine(List<Coordinate> coordinates) {
        Map<Double, Long> lineGradientCountMap = toLines(coordinates).stream()
                .collect(Collectors.groupingBy(Line::calculateGradient, Collectors.counting()));

        return lineGradientCountMap.values()
                .stream()
                .anyMatch(inLineCoordinates -> inLineCoordinates >= POLYGON_COORDINATES);
    }

    public List<Line> toLines(List<Coordinate> coordinates) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0, length = coordinates.size(); i < length - 1; i++) {
            matchUnmetCoordinates(lines, coordinates, i);
        }
        return lines;
    }

    private void matchUnmetCoordinates(List<Line> lines, List<Coordinate> coordinates, int coordinateIndex) {
        for (int j = coordinateIndex + 1, length = coordinates.size(); j < length; j++) {
            lines.add(new Line(Arrays.asList(coordinates.get(coordinateIndex), coordinates.get(j))));
        }
    }

    public Coordinate get(int index) {
        return coordinates.get(index);
    }

    public int size() {
        return coordinates.size();
    }
}
