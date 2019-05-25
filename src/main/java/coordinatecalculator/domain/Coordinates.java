package coordinatecalculator.domain;

import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Coordinates {
    private final List<Coordinate> coordinates;

    public Coordinates(final List<Coordinate> coordinates, final int numberOfCoordinate) {
        Preconditions.checkArgument(new HashSet<>(coordinates).size() == numberOfCoordinate,
                "중복되는 좌표가 있습니다!");
        this.coordinates = coordinates;
    }

    public double getDistanceBetweenTwoPoints(final int first, final int second) {
        return coordinates.get(first).calculateDistance(coordinates.get(second));
    }

    public double getSlopeBetweenTwoPoints(final int first, final int second) {
        return coordinates.get(first).calculateSlope(coordinates.get(second));
    }

    public List<Coordinate> getCoordinates() {
        return Collections.unmodifiableList(coordinates);
    }

    public int getNumberOfCoordinates() {
        return coordinates.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coordinates that = (Coordinates) o;
        return Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
