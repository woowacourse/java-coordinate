package coordinatecalculator.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triangle implements Figure {

    private static final int FIRST_DISTANCE = 0;
    private static final int SECOND_DISTANCE = 1;
    private static final int THIRD_DISTANCE = 2;
    public static final int TRIANGLE_SIZE = 3;
    private static final int START = 0;
    private static final int NEXT = 1;
    private final Points points;

    public Triangle(Points points) {
        this.points = points;
        checkValidate();
    }

    private double calculateArea(List<Distance> distances) {
        double firstLength = distances.get(FIRST_DISTANCE).getDistance();
        double secondLength = distances.get(SECOND_DISTANCE).getDistance();
        double thirdLength = distances.get(THIRD_DISTANCE).getDistance();

        final double pythagorean = firstLength * firstLength + secondLength * secondLength - thirdLength * thirdLength;
        return Math.sqrt(4 * firstLength * firstLength * secondLength * secondLength - pythagorean * pythagorean) / 4;
    }

    public void checkValidate() {
        Set<Double> inclidations = new HashSet<>();
        for (int i = START; i < TRIANGLE_SIZE; i++) {
            inclidations.add(points.getPoint(i).getSlope(points.getPoint((i + NEXT) % TRIANGLE_SIZE)));
        }
        if(inclidations.size()!=TRIANGLE_SIZE){
            throw new IllegalArgumentException("잘못된 삼각형 입니다.");
        }
    }

    @Override
    public double area() {
        double area = calculateArea(points.generateDistances());
        return Math.round(area * DECIMAL) / DECIMAL;
    }

    @Override
    public String toString() {
        return "삼각형의 넓이는 " + area();
    }
}
