package coordinatecalculator.domain;

import coordinatecalculator.visitor.ViewVisitor;

import java.util.List;

public interface Shape {
    void isValidShape(final List<Coordinate> coordinates);

    String separateByVisitor(final ViewVisitor viewVisitor);

    List<Coordinate> getCoordinate();
}
