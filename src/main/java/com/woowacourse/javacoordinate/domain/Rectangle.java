package com.woowacourse.javacoordinate.domain;

import java.util.*;

public class Rectangle extends Figure {
    public static final int RECTANGLE_POINT_NUMBER = 4;
    private static final int POSITION_NUMBER = 2;

    public Rectangle(Points points) {
        super(points);

        if (points.getSize() != RECTANGLE_POINT_NUMBER) {
            throw new IllegalArgumentException("사각형은 4개의 Point가 필요합니다");
        }

        checkValidRectangle(points);
    }

    private void checkValidRectangle(Points points) {
        Set<Integer> xAxises = new HashSet<>();
        Set<Integer> yAxises = new HashSet<>();

        points.getPoints().stream().map(Point::getX).forEach(xAxises::add);
        points.getPoints().stream().map(Point::getY).forEach(yAxises::add);

        if (xAxises.size() != POSITION_NUMBER || yAxises.size() != POSITION_NUMBER) {
            throw new IllegalArgumentException("유효한 사각형이 아닙니다");
        }
    }


    @Override
    public double calculateArea() {
        List<Double> list = getDistances();

        return list.get(0) * list.get(1);
    }

    @Override
    public double calculateLength() {
        List<Double> list = getDistances();

        return (list.get(0) + list.get(1)) * 2;
    }

    private List<Double> getDistances() {
        List<Point> vertices = points.getPoints();

        Point point1 = vertices.get(0);
        Point point2 = vertices.get(1);
        Point point3 = vertices.get(2);
        Point point4 = vertices.get(3);

        double distance1 = point1.getDistance(point2);
        double distance2 = point1.getDistance(point3);
        double distance3 = point1.getDistance(point4);

        List<Double> list = Arrays.asList(distance1, distance2, distance3);
        Collections.sort(list);
        return list;
    }
}
