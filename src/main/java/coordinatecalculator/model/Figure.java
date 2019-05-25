package coordinatecalculator.model;

public interface Figure {
    Points getPoints();
    double area();
    double distance(int originPointIndex, int destinationPointIndex);
}
