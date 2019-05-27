package coordinatecalculator.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangle implements Figure {

    private static final int FIRST_DISTANCE = 0;
    private static final int SECOND_DISTANCE = 1;
    private static final int THIRD_DISTANCE = 2;
    private static final int TRIANGLE_SIZE = 3;
    private static final int TWO = 2;
    private static final int FOUR = 4;
    private static final int START = 0;
    private static final int NEXT = 1;
    private final Points points;

    public Triangle(Points points) {
        this.points = points;
        checkValidate();
    }

    private double calculateArea(List<Distance> distances) {
        double squareOfFirstLength = Math.pow(distances.get(FIRST_DISTANCE).getDistance(), TWO);
        double squareOfSecondLength = Math.pow(distances.get(SECOND_DISTANCE).getDistance(), TWO);
        double squareOfThirdLength = Math.pow(distances.get(THIRD_DISTANCE).getDistance(), TWO);


        final double squareOfPythagorean = Math.pow(squareOfFirstLength + squareOfSecondLength - squareOfThirdLength,2);
        return Math.sqrt(FOUR * squareOfFirstLength * squareOfSecondLength - squareOfPythagorean) / FOUR;
    }

    public void checkValidate() {
        Set<Double> inclidations = new HashSet<>();
        for (int i = START; i < TRIANGLE_SIZE; i++) {
            inclidations.add(points.getPointByIndex(i).getSlope(points.getPointByIndex((i + NEXT) % TRIANGLE_SIZE)));
        }
        if (inclidations.size() != TRIANGLE_SIZE) {
            throw new IllegalArgumentException("잘못된 삼각형 입니다.");
        }
    }

    @Override
    public double getArea() {
        double area = calculateArea(points.generateDistances());
        return Math.round(area * DECIMAL) / DECIMAL;
    }

    @Override
    public String toString() {
        return points +"삼각형의 넓이는 "+ getArea();
    }
}
