package coord.model;

public abstract class Figure {
    protected final Points points;

    protected Figure(Points points) {
        this.points = points;
    }

    abstract double area();
}