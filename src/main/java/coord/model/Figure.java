package coord.model;

public abstract class Figure {
    protected final Points points;

    public static Figure make(Points points) {
        switch (points.number()) {
            case 3:
                return new Triangle(points);
            case 4:
                return new Rectangle(points);
            default:
                throw new IllegalArgumentException();
        }
    }

    protected Figure(Points points) {
        this.points = points;
    }

    public abstract double area();

    public abstract String getName();
}