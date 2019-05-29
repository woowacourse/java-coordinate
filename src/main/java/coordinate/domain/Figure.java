package coordinate.domain;

public abstract class Figure implements Shape {
    Points points;

    Figure(Points points) {
        this.points = points;
    }

    public abstract double calculateFigure();

    public abstract String getName();

    public abstract String getOperationName();
}