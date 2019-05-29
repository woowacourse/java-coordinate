package coordinatecalculator.model;

public abstract class Figure {
    protected final Points points;

    Figure(Points points) {
        this.points = points;
    }

    abstract double getResult();

    abstract double calculateResult();
}
