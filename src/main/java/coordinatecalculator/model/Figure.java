package coordinatecalculator.model;

import java.util.List;

public abstract class Figure {

    abstract double calculateArea(List<Distance> distances);

    abstract double getArea();

}
