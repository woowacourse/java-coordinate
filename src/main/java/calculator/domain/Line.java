package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line extends AbstractFigure {
    private final FigureType figureType;
    private final Coordinates coordinates;

    public Line(FigureType figureType) {
        this.figureType = figureType;
        this.coordinates = figureType.getCoordinates();
    }

    @Override
    public double area() {
        return coordinates.get(0).straight(coordinates.get(1));
    }

    @Override
    public String getName() {
        return figureType.getType();
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
