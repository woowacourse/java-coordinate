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
        return coordinates.get(0).straight(coordinates.get(1));
    }

    @Override
    void checkFigureCondition() {
        // 값이 같을 경우
    }

    @Override
    Coordinates getCoordinates() {
        return coordinates;
    }
}
