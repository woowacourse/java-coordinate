package com.woowa.coordinate;

import java.util.Objects;

public class Coordinate {
    private final int coordinate;

    public Coordinate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("좌표값은 0미만이 될 수 없습니다.");
        }
        if (i > 24) {
            throw new IllegalArgumentException("좌표값은 24를 초과할 수 없습니다.");
        }
        this.coordinate = i;
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

    public double subtract(Coordinate coordinate) {
        return Math.pow(this.coordinate - coordinate.coordinate, 2);
    }
}
