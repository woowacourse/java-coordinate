package com.woowacourse.javacoordinate.domain.figure;

import com.woowacourse.javacoordinate.domain.point.Point;
import com.woowacourse.javacoordinate.domain.point.Points;

import java.util.Arrays;
import java.util.List;

public class Triangle extends Figure {
    public static final String TYPE_OF_TRIANGLE = "Triangle";
    public static final int TRIANGLE_POINT_NUMBER = 3;

    public Triangle(Points points) {
        super(points);

        if (points.getSize() != TRIANGLE_POINT_NUMBER) {
            throw new IllegalArgumentException("삼각형은 3개의 Point가 필요합니다");
        }

        checkVerticesInLine();
        this.type = TYPE_OF_TRIANGLE;
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
        List<Double> lengths = calculateLengthOfSide();

        double s = (lengths.get(0) + lengths.get(1) + lengths.get(2)) / 2;

        return Math.sqrt(s * (s - lengths.get(0)) * (s - lengths.get(1)) * (s - lengths.get(2)));
    }

    @Override
    public double calculateLength() {
        List<Double> lengths = calculateLengthOfSide();

        return lengths.get(0) + lengths.get(1) + lengths.get(2);
    }

    private List<Double> calculateLengthOfSide() {
        List<Point> vertices = points.getPoints();

        Point firstInputPoint = vertices.get(0);
        Point secondInputPoint = vertices.get(1);
        Point thirdInputPoint = vertices.get(2);

        double LengthBetweenFirstAndSecond = firstInputPoint.calculateDistance(secondInputPoint);
        double LengthBetweenFirstAndThird = firstInputPoint.calculateDistance(thirdInputPoint);
        double LengthBetweenSecondAndThird = secondInputPoint.calculateDistance(thirdInputPoint);

        return Arrays.asList(LengthBetweenFirstAndSecond, LengthBetweenFirstAndThird, LengthBetweenSecondAndThird);
    }

}