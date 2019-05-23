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
    public double area() {
        return straight(coordinates.get(0), coordinates.get(1));
    }
}
