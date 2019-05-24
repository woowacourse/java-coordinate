package coordinate.domain;

public abstract class Figure implements Shape {
    String name;
    Points points;

    Figure(Points points) {
        this.points = points;
    }

    public abstract double calculateFigure();
    public String getName() {
        return name;
    }
}
