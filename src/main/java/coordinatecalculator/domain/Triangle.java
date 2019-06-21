package coordinatecalculator.domain;

import coordinatecalculator.visitor.Visitor;

import java.util.*;

public class Triangle implements Figure, Shape {
    private final List<Coordinate> coordinates;
    public static final int VERTEX_OF_TRIANGLE = 3;
    private static final int FIRST_VERTEX = 0;
    private static final int SECOND_VERTEX = 1;
    private static final int THIRD_VERTEX = 2;

    public Triangle(final List<Coordinate> coordinates) {
        isValidShape(coordinates);
        isValidTriangle(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidTriangle(final List<Coordinate> coordinates) {
        double slopeFirst = coordinates.get(FIRST_VERTEX).calculateSlope(coordinates.get(SECOND_VERTEX));
        double slopeSecond = coordinates.get(SECOND_VERTEX).calculateSlope(coordinates.get(THIRD_VERTEX));

        if (slopeFirst == slopeSecond) {
            throw new IllegalArgumentException("삼각형이 아니에요");
        }
    }

    @Override
    public double getArea() {
        double line1 = coordinates.get(FIRST_VERTEX).calculateDistance(coordinates.get(SECOND_VERTEX));
        double line2 = coordinates.get(SECOND_VERTEX).calculateDistance(coordinates.get(THIRD_VERTEX));
        double line3 = coordinates.get(THIRD_VERTEX).calculateDistance(coordinates.get(FIRST_VERTEX));

        //해론의 법칙
        return Math.sqrt((line1 + line2 + line3) * (line2 - line1 + line3) * (line1 - line2 + line3) * (line1 + line2 - line3)) / 4;
    }

    @Override
    public void isValidShape(List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_TRIANGLE) {
            throw new IllegalArgumentException("위치가 같은 점(point)이 존재합니다. 세 점의 위치는 달라야 합니다.");
        }
    }

    @Override
    public String separateShapeByVisitor(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return Collections.unmodifiableList(coordinates);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Triangle triangle = (Triangle) o;
        return Objects.equals(coordinates, triangle.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
