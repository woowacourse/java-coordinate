package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line extends AbstractFigure {
    private final Coordinates coordinates;

    public Line(FigureType figureType) {
        super(figureType);
        this.coordinates = getCoordinates();
    }

    @Override
    public double perimeter() {
        return coordinates.get(0).straight(coordinates.get(1));
    }

    @Override
    public double area() {
        return perimeter();
    }

    @Override
    void checkFigureCondition() {
        // 값이 같을 경우
    }
}
