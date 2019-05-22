package coordinatecalculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Triangle implements Figure, Shape {
    private List<Coordinate> coordinates;
    private static final int VERTEX_OF_TRIANGLE = 3;

    public Triangle(final List<Coordinate> coordinates) {
        isValidShape(coordinates);
        isValidTriangle(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidTriangle(final List<Coordinate> coordinates) {
        Set<Integer> overlapX = new HashSet<>();
        Set<Integer> overlapY = new HashSet<>();

        for (Coordinate coordinate : coordinates) {
            overlapX.add(coordinate.getX());
            overlapY.add(coordinate.getY());
        }

        if (overlapX.size() == 1 || overlapY.size() == 1) {
            throw new IllegalArgumentException("삼각형이 아니에요");
        }
    }

    @Override
    public double area() {
        double line1 = coordinates.get(0).calculate(coordinates.get(1));
        double line2 = coordinates.get(1).calculate(coordinates.get(2));
        double line3 = coordinates.get(2).calculate(coordinates.get(0));

        return Math.sqrt((line1 + line2 + line3) * (line2 - line1 + line3) * (line1 - line2 + line3) * (line1 + line2 - line3)) / 4;
    }

    @Override
    public double getScore() {
        return area();
    }

    @Override
    public void isValidShape(List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_TRIANGLE) {
            throw new IllegalArgumentException("위치가 같은 점(point)이 존재합니다. 세 점의 위치는 달라야 합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Triangle triangle = (Triangle) o;
        return Objects.equals(coordinates, triangle.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
