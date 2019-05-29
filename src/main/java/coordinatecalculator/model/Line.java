package coordinatecalculator.model;

import java.util.Objects;

public class Line extends Figure {
    private static final int DISTANCES_FIRST_INDEX = 0;

    private double distance;

    public Line(final Points points) {
        super(points);
        this.distance = calculateResult();
    }

    @Override
    public double getResult() {
        return distance;
    }

    @Override
    public double calculateResult() {
        return points.generateDistances().get(DISTANCES_FIRST_INDEX).getDistance();
    }

    @Override
    public String toString() {
        return "두 점 사이 거리는 " + String.format("%.6f", getResult());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Double.compare(line.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
