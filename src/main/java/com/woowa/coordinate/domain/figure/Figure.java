package com.woowa.coordinate.domain.figure;

import com.woowa.coordinate.domain.Points;

public interface Figure {
    Points getPoints();

    int size();

    String name();

    double area();
}
