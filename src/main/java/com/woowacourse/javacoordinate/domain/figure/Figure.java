package com.woowacourse.javacoordinate.domain.figure;

import com.woowacourse.javacoordinate.domain.point.Points;

import java.util.Objects;

public abstract class Figure implements FigureCalculator {
    protected Points points;

    Figure(Points points) {
        if (Objects.isNull(points)) {
            throw new NullPointerException();
        }

        this.points = points;
    }

    public int getPointsSize() {
        return points.getSize();
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
