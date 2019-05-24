package coordinate.domain.figure;

import coordinate.domain.nonefigure.PointGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle extends Figure implements AreaCalculable {
    private static final int POINT_COUNT = 3;

    public Triangle(PointGroup points) {
        super(points, POINT_COUNT);
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("삼각형은 3개의 점으로 이루어져야 합니다.");
        }
        List<Line> lines = points.getLines();
        Collections.sort(lines);
        List<Double> lineLengths = new ArrayList();
        lines.forEach(line -> lineLengths.add(line.length()));

        checkStraightLine(lineLengths);
    }

    private void checkStraightLine(List<Double> lineLengths) {
        if (BigDecimal.valueOf(lineLengths.get(2))
                .compareTo(BigDecimal.valueOf(lineLengths.get(1) + lineLengths.get(0))) == 0) {
            throw new IllegalStateException("일직선 상 3개의 점은 허용하지 않습니다.");
        }
    }

    public double area() {
        List<Double> squaredLineLengths = new ArrayList<>();
        getPoints().getLines().forEach(
                line -> squaredLineLengths.add(Math.pow(line.length(), 2)));
        return useHeronEquations(squaredLineLengths);
    }

    private double useHeronEquations(List<Double> squaredLineLengths) {
        return Math.sqrt(4 * squaredLineLengths.get(0) * squaredLineLengths.get(1)
                - Math.pow((squaredLineLengths.get(0) + squaredLineLengths.get(1) - squaredLineLengths.get(2)), 2)) / 4;
    }

    @Override
    public String toString() {
        return "삼각형";
    }
}
