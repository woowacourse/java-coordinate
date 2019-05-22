package coord.model;

public abstract class Figure {
    protected final Points points;

    public static Figure fromPoints(Points points) {
        if (points.number() < 3) {
            throw new IllegalArgumentException("점의 개수가 너무 적습니다.");
        }
        if (points.number() == 3) {
            return new Triangle(points);
        }
        return new Rectangle(new Points(points.getPoints().subList(0, 4)));
    }

    protected Figure(Points points) {
        this.points = points;
    }

    public abstract double area();

    public abstract String getName();
}