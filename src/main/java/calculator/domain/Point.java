package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Point extends Figure {
    private final Coordinates coordinates;

    public Point(Coordinates coordinates) {
        super("한 점", "길이");
        this.coordinates = coordinates;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    void checkFigureCondition() {

    }

    @Override
    Coordinates getCoordinates() {
        return coordinates;
    }
}
