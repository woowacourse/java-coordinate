package com.woowacourse.javacoordinate.domain;

import java.util.Arrays;
import java.util.List;

public class Triangle extends Figure {
    private static final int TRIANGLE_POINT_NUMBER = 3;

    public Triangle(Points points) {
        super(points);

        if (points.getSize() != TRIANGLE_POINT_NUMBER) {
            throw new IllegalArgumentException("삼각형은 3개의 Point가 필요합니다");
        }

        checkVerticesInLine();
    }

    private void checkVerticesInLine() {
        List<Point> vertices = points.getPoints();
        int dx1 = vertices.get(0).getX() - vertices.get(1).getX();
        int dy1 = vertices.get(0).getY() - vertices.get(1).getY();
        int dx2 = vertices.get(1).getX() - vertices.get(2).getX();
        int dy2 = vertices.get(1).getY() - vertices.get(2).getY();

        if (Math.atan2(dx1, dy1) == Math.atan2(dx2, dy2)) {
            throw new IllegalArgumentException("모든 Point가 한 직선에 있습니다.");
        }
    }

    @Override
    public double calculateArea() {
        List<Double> distances = getDistances();

        double s = (distances.get(0) + distances.get(1) + distances.get(2)) / 2;

        return Math.sqrt(s * (s - distances.get(0)) * (s - distances.get(1)) * (s - distances.get(2)));
    }

    @Override
    public double calculateLength() {
        List<Double> distances = getDistances();

        return distances.get(0) + distances.get(1) + distances.get(2);
    }

    private List<Double> getDistances() {
        List<Point> vertices = points.getPoints();
        Point point1 = vertices.get(0);
        Point point2 = vertices.get(1);
        Point point3 = vertices.get(2);

        double distance1 = point1.getDistance(point2);
        double distance2 = point1.getDistance(point3);
        double distance3 = point2.getDistance(point3);

        return Arrays.asList(distance1, distance2, distance3);
    }

}