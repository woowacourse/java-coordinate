package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.coordinate.Coordinates;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

public class Lines {
    private static final int INLINE_COORDINATE_LIMIT = 3;

    private final List<Line> lines;

    public Lines(Coordinates coordinates) {
        List<Line> lines = generateLines(coordinates);
        checkThreeCoordinatesInLine(lines);
        Collections.sort(lines);
        this.lines = lines;
    }

    private void checkThreeCoordinatesInLine(List<Line> lines) {
        Map<Double, Long> lineLengthCountMap = lines.stream()
                .collect(Collectors.groupingBy(Line::calculateGradient, Collectors.counting()));

        if (lineLengthCountMap.values().stream().anyMatch(i -> i >= INLINE_COORDINATE_LIMIT)) {
            throw new IllegalArgumentException("세 좌표가 한 직선 위에 있습니다.");
        }
    }

    private List<Line> generateLines(Coordinates coordinates) {
        List<Line> lines = new ArrayList<>();
        List<Coordinate> coordinateList = new ArrayList<>(coordinates.getCoordinates());

        do {
            Coordinate a = coordinateList.get(0);
            coordinateList.remove(a);
            lines.addAll(matchCoordinates(a, coordinateList));
        } while (coordinateList.size() != 0);

        return lines;
    }

    private List<Line> matchCoordinates(Coordinate a, List<Coordinate> coordinateList) {
        List<Line> lines = new ArrayList<>();

        for (Coordinate b : coordinateList) {
            lines.add(new Line(Arrays.asList(a, b)));
        }
        return lines;
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }

    public Line get(int index) {
        return lines.get(index);
    }
}
