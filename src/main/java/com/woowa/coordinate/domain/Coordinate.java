package com.woowa.coordinate.domain;

import java.util.Objects;

public class Coordinate {
    private static final String LOWER_BOUND_ERROR = "좌표값은 0미만이 될 수 없습니다.";
    private static final String UPPER_BOUND_ERROR = "좌표값은 24를 초과할 수 없습니다.";
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 24;

    private final int coordinate;

    public Coordinate(int coordinate) {
        validLowerBound(coordinate);
        validUpperBound(coordinate);
        this.coordinate = coordinate;
    }

    private void validUpperBound(int coordinate) {
        if (coordinate > UPPER_BOUND) {
            throw new IllegalArgumentException(UPPER_BOUND_ERROR);
        }
    }

    private void validLowerBound(int coordinate) {
        if (coordinate < LOWER_BOUND) {
            throw new IllegalArgumentException(LOWER_BOUND_ERROR);
        }
    }

    public int subtract(Coordinate coordinate) {
        return this.coordinate - coordinate.coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return coordinate == that.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
