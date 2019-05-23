package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line extends Figure {
    private final Coordinates points;

    public Line(Coordinates points) {
        super("직선", "거리");
        this.points = points;
    }

    @Override
    public double calculate() {
        Coordinate a = points.get(0);
        Coordinate b = points.get(1);
        return Math.sqrt(Math.pow(a.getX()-b.getX(),2) + Math.pow(a.getY() - b.getY(),2));
    }

}
