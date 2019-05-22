package com.woowacourse.javacoordinate.domain;

import java.util.*;

public class Rectangle extends Figure {
    public Rectangle(Points points) {
        super(points);

        if (points.getSize() != 4) {
            throw new IllegalArgumentException("사각형은 4개의 Point가 필요합니다");
        }

        checkValidRectangle(points);
    }

    private void checkValidRectangle(Points points) {
        Point point1 = points.getPoints().get(0);
        Point point2 = points.getPoints().get(1);
        Point point3 = points.getPoints().get(2);
        Point point4 = points.getPoints().get(3);

        Set<Integer> xAxises = new HashSet<>(Arrays.asList(point1.getX(), point2.getX(), point3.getX(), point4.getX()));
        Set<Integer> yAxises = new HashSet<>(Arrays.asList(point1.getY(), point2.getY(), point3.getY(), point4.getY()));

        if (xAxises.size() != 2 || yAxises.size() != 2) {
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
