package coordinatecalculator.domain;

import coordinatecalculator.visitor.ViewVisitor;

import java.util.List;

public interface Shape {
    int FIRST_COORDINATE = 0;
    int SECOND_COORDINATE = 1;

    String separateByVisitor(final ViewVisitor viewVisitor);

    List<Coordinate> getCoordinate();
}
