package coordinatecalculator.domain;

import coordinatecalculator.visitor.Visitor;

import java.util.List;

public interface Shape {
    void isValidShape(final List<Coordinate> coordinates);

    String separateByVisitor(final Visitor visitor);

    List<Coordinate> getCoordinate();
}
