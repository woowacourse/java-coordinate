package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Points;

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
}
