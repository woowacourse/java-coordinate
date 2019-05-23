package coordinate.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Triangle {
    private static final int POINT_COUNT = 3;
    private final PointGroup points;

    public Triangle(PointGroup points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("삼각형은 3개의 점으로 이루어져야 합니다.");
        }
        List<Double> distances = points.getTriagleSquareDistances();
        Collections.sort(distances);
        distances = distances.stream().map(x -> Math.sqrt(x)).collect(Collectors.toList());
        if (BigDecimal.valueOf(distances.get(2)).compareTo(BigDecimal.valueOf(distances.get(1) + distances.get(0))) == 0) {
            throw new IllegalStateException("일직선 상 3개의 점은 허용하지 않습니다.");
        }
    }

    public double area() {
        return useHeronEquations(points.getTriagleSquareDistances());
    }

    private double useHeronEquations(List<Double> squaredDistances) {
        return Math.sqrt(4 * squaredDistances.get(0) * squaredDistances.get(1)
                - Math.pow((squaredDistances.get(0) + squaredDistances.get(1) - squaredDistances.get(2)), 2)) / 4;
    }
}
