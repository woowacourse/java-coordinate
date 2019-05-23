package coordinatecalculator.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rectangle extends PlaneFigure {

    public Rectangle(List<Coordinate> coordinates) {
        super(coordinates);
        checkValidRectangle(lines);
    }

    private void checkValidRectangle(List<Line> lines) {
        Map<Double, Long> lineLengthCountMap = lines.stream()
                .collect(Collectors.groupingBy(Line::getLength, Collectors.counting()));

        if (lineLengthCountMap.values().stream().anyMatch(i -> i % 2 == 1)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    @Override
    public double calculateArea() {
        Collections.sort(lines);
        return lines.get(0).getLength() * lines.get(2).getLength();
    }
}
