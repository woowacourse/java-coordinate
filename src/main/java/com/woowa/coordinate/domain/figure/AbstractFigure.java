package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Points;

import java.util.Objects;

public abstract class AbstractFigure implements Figure {
    private final Points points;

    public AbstractFigure(Points points) {
        if (points.size() != size()) {
            throw new IllegalArgumentException(name() + "의 길이는 " + size() + "이어야 합니다.");
        }
        this.points = points;
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    public abstract int size();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
