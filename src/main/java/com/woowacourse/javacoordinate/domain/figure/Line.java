package com.woowacourse.javacoordinate.domain.figure;

import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;

import java.util.List;

public class Line extends Figure {
    public static final String TYPE_OF_LINE = "Line";
    public static final int LINE_POINT_NUMBER = 2;

    public Line(Points points) {
        super(points);

        if (points.getSize() != LINE_POINT_NUMBER) {
            throw new IllegalArgumentException("라인은 2개의 Point가 필요합니다");
        }

        this.type = TYPE_OF_LINE;
    }

    @Override
    public double calculateArea() {
        throw new RuntimeException("선은 넓이가 존재하지 않습니다.");
    }

    @Override
    public double calculateLength() {
        Point point = points.getPoints().get(0);
        List<Point> vertices = points.getPoints();
        double length = 0;

        for (int i = 1; i < points.getSize(); i++) {
            length += point.calculateDistance(vertices.get(i));
        }

        return length;
    }
}
