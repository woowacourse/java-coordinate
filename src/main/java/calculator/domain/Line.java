package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line extends AbstractFigure {
    private final Points points;

    public Line(FigureType figureType) {
        super(figureType);
        this.points = getCoordinates();
    }

    @Override
    public double perimeter() {
        return points.get(0).straight(points.get(1));
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    void checkFigureCondition() {
    }
}
