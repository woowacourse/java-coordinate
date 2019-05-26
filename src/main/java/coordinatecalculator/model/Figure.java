package coordinatecalculator.model;

public interface Figure {
    int getPointSize();

    Points getPoints();

    double area();

    double distance(int originPointIndex, int destinationPointIndex);
}
