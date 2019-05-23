package coordinatecalculator.domain;

import coordinatecalculator.visitor.Visitor;

import java.util.List;

public interface Shape {
    void isValidShape(List<Coordinate> coordinates);

    String separateByVisitor(Visitor visitor);
}
