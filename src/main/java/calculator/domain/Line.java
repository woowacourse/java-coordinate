package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line extends AbstractFigure {
    private final Coordinates coordinates;

    public Line(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public double area() {
        return coordinates.get(0).straight(coordinates.get(1));
    }

    @Override
    public String getName() {
        return "직선";
    }

    @Override
    public String getCalculateTarget() {
        return "거리";
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
