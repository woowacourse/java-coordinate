package com.woowacourse.javacoordinate.domain;

import java.util.Objects;

public abstract class Figure implements FigureCalculator {
    protected Points points;

    public Figure(Points points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(points, figure.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
