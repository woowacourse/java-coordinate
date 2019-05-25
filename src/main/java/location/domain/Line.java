package location.domain;

public class Line extends Figure {
    private static final int SQUARE = 2;

    public Line(final Points points) {
        super(points);
    }

    @Override
    public double calculate() {
        return Math.sqrt(Math.pow((points.get(0).getX() - points.get(1).getX()), SQUARE)
                + Math.pow((points.get(0).getY() - points.get(1).getY()), SQUARE));
    }

    @Override
    public Points getPoints() {
        return this.points;
    }
}
