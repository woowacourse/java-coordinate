package com.woowacourse.javacoordinate.domain;

import java.util.*;

public class Rectangle extends Figure {
    public static final String TYPE_OF_RECTANGLE = "Rectangle";
    public static final int RECTANGLE_POINT_NUMBER = 4;
    private static final int POSITION_NUMBER = 2;

    public Rectangle(Points points) {
        super(points);

        if (points.getSize() != RECTANGLE_POINT_NUMBER) {
            throw new IllegalArgumentException("사각형은 4개의 Point가 필요합니다");
        }

        checkValidRectangle(points);
        this.type = TYPE_OF_RECTANGLE;
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
        List<Double> lengths = calculateLengthOfSide();

        return lengths.get(0) * lengths.get(1);
    }

    @Override
    public double calculateLength() {
        List<Double> lengths = calculateLengthOfSide();

        return (lengths.get(0) + lengths.get(1)) * 2;
    }

    private List<Double> calculateLengthOfSide() {
        List<Point> vertices = points.getPoints();

        Point firstInputPoint = vertices.get(0);
        Point secondInputPoint = vertices.get(1);
        Point thirdInputPoint = vertices.get(2);
        Point fourthInputPoint = vertices.get(3);

        double LengthBetweenFirstAndSecond = firstInputPoint.calculateDistance(secondInputPoint);
        double LengthBetweenFirstAndThird = firstInputPoint.calculateDistance(thirdInputPoint);
        double LengthBetweenFirstAndFourth = firstInputPoint.calculateDistance(fourthInputPoint);

        List<Double> list = Arrays.asList(
                LengthBetweenFirstAndSecond, LengthBetweenFirstAndThird, LengthBetweenFirstAndFourth);
        Collections.sort(list);
        return list;
    }
}
