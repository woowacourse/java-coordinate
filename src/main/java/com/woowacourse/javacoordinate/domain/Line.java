package com.woowacourse.javacoordinate.domain;

import java.util.List;

public class Line extends Figure {
    private static final int LINE_POINT_NUMBER = 2;

    public Line(Points points) {
        super(points);

        if (points.getSize() != LINE_POINT_NUMBER) {
            throw new IllegalArgumentException("라인은 2개의 Point가 필요합니다");
        }
    }

    @Override
    public double calculateArea() {
        throw new RuntimeException("선은 넓이가 존재하지 않습니다.");
    }

    @Override
    public double calculateLength() {
        Point point = points.getPoints().get(0);
        List<Point> vertices = points.getPoints();
        double distance = 0;

        for (int i = 1; i < points.getSize(); i++) {
            distance += point.getDistance(vertices.get(i));
        }

        return distance;
    }
}
