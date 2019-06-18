package com.woowa.coordinate.domain;

import com.woowa.coordinate.domain.figure.Figure;

public interface FigureMaker {
    Figure make(Points points);
}
