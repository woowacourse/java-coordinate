package coordinatecalculator.domain;

import coordinatecalculator.visitor.Visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Triangle implements Figure, Shape {
    private static final int VERTEX_OF_TRIANGLE = 3;

    private List<Coordinate> coordinates;

    public Triangle(final List<Coordinate> coordinates) {
        isValidShape(coordinates);
        isValidTriangle(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidTriangle(final List<Coordinate> coordinates) {
        double slopeFirst = coordinates.get(0).calculateSlope(coordinates.get(1));
        double slopeSecond = coordinates.get(1).calculateSlope(coordinates.get(2));

        if (slopeFirst == slopeSecond) {
            throw new IllegalArgumentException("삼각형이 아니에요");
        }
    }

    @Override
    public double area() {
        double line1 = coordinates.get(0).calculateDistance(coordinates.get(1));
        double line2 = coordinates.get(1).calculateDistance(coordinates.get(2));
        double line3 = coordinates.get(2).calculateDistance(coordinates.get(0));

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
    public String separateByVisitor(final Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return coordinates;
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
