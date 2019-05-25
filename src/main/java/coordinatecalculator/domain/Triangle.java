package coordinatecalculator.domain;

import com.google.common.base.Preconditions;
import coordinatecalculator.visitor.ViewVisitor;

import java.util.List;
import java.util.Objects;

public class Triangle implements Figure, Shape {
    public static final int VERTEX_OF_TRIANGLE = 3;
    private static final int THIRD_COORDINATE = 2;

    private Coordinates coordinates;

    public Triangle(final Coordinates coordinates) {
        isValidTriangle(coordinates);
        this.coordinates = coordinates;
    }

    private void isValidTriangle(final Coordinates coordinates) {
        double slopeFirst = coordinates.getSlopeBetweenTwoPoints(FIRST_COORDINATE, SECOND_COORDINATE);
        double slopeSecond = coordinates.getSlopeBetweenTwoPoints(SECOND_COORDINATE, THIRD_COORDINATE);
        Preconditions.checkArgument(slopeFirst != slopeSecond, "삼각형이 아니에요");
    }

    @Override
    public double area() {
        double line1 = coordinates.getDistanceBetweenTwoPoints(FIRST_COORDINATE, SECOND_COORDINATE);
        double line2 = coordinates.getDistanceBetweenTwoPoints(SECOND_COORDINATE, THIRD_COORDINATE);
        double line3 = coordinates.getDistanceBetweenTwoPoints(2, 0);

        //해론의 법칙
        return Math.sqrt((line1 + line2 + line3) * (line2 - line1 + line3) * (line1 - line2 + line3) * (line1 + line2 - line3)) / 4;
    }

    @Override
    public String separateByVisitor(final ViewVisitor viewVisitor) {
        return viewVisitor.visit(this);
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return coordinates.getCoordinates();
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
