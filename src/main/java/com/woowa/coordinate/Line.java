package com.woowa.coordinate;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> line;

    public Line(List<Point> line) {
        if (line.size() != 2) {
            throw new IllegalArgumentException("Line 은 점 2개로 생성이 가능합니다.");
        }
        this.line = new ArrayList<>(line);
    }

    public double distance() {
        return Math.sqrt(line.get(0).distance(line.get(1)));
    }
}
