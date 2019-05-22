package coordinatecalculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangle {
    private List<Coordinate> coordinates;

    public Triangle(final List<Coordinate> coordinates) {
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


}
