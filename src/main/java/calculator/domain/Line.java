package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line extends Figure {
    private final Coordinates coordinates;

    public Line(Coordinates coordinates) {
        super("직선", "거리");
        this.coordinates = coordinates;
    }

    @Override
    public double calculate() {
        Coordinate a = coordinates.get(0);
        Coordinate b = coordinates.get(1);
        return Math.sqrt(Math.pow(a.getX()-b.getX(),2) + Math.pow(a.getY() - b.getY(),2));
    }

}
