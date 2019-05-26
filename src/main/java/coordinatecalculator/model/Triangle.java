package coordinatecalculator.model;

import java.util.HashSet;
import java.util.Set;

public class Triangle implements Figure {
    private static final int TRIANGLE_SIZE = 3;
    private static final int START = 0;
    private static final int NEXT = 1;
    private static final int DEGREE_OF_THIRD_PRECISION = 1000;

    private double area;

    public Triangle(final Points points){
        this.area = calculateResult(validateTrianglePoints(points));
    }

    private Points validateTrianglePoints(Points points){
        Set<Double> checkSlops = new HashSet<>();
        for (int i = START; i < TRIANGLE_SIZE; i++) {
            checkSlops.add(points.getPoint(i).getSlope(points.getPoint((i + NEXT) % TRIANGLE_SIZE)));
        }
        if(checkSlops.size() != TRIANGLE_SIZE){
            throw new IllegalArgumentException("잘못된 삼각형 입니다.");
        }
        return points;
    }

    private double getTriangleArea(double firstLine, double secondLine, double thirdLine){
        final double pythagorean = firstLine * firstLine + secondLine * secondLine - thirdLine * thirdLine;
        return Math.sqrt(4 * firstLine * firstLine * secondLine * secondLine - pythagorean * pythagorean) / 4;
    }

    @Override
    public double getResult() {
        return Math.round(area * DEGREE_OF_THIRD_PRECISION) / DEGREE_OF_THIRD_PRECISION;
    }

    @Override
    public double calculateResult(final Points points){
        double firstLine = points.generateDistances().get(0).getDistance();
        double secondLine = points.generateDistances().get(1).getDistance();
        double thirdLine = points.generateDistances().get(2).getDistance();

        return getTriangleArea(firstLine, secondLine, thirdLine);
    }
}
