package com.woowa.coordinate.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Square {
    private final List<Point> points;

    public Square(List<Point> points) {
        if(points.size() != 4) {
            throw new IllegalArgumentException("사각형은 점 4개로 생성 가능 합니다.");
        }
        // TODO: Valid Rectangle
        this.points = points;
    }

    public double area() {
        List<Double> lines = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            lines.add(points.get((i) % 4).distance(points.get((i + 1) % 4)));
        }
        double width = Collections.max(lines);
        double height = Collections.min(lines);
        return width * height;
    }
}
