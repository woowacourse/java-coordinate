package coord.model.figure;

public abstract class Figure {
    protected final Points points;
    protected double areaCache = .0;

    protected Figure(Points points) {
        this.points = points;
    }

    public abstract double area();

    public int getNumberOfAngles() {
        return points.number();
    }
}