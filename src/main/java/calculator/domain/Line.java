package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Line extends AbstractFigure implements Comparable<Line> {
    private final Points points;

    public Line(FigureType figureType) {
        super(figureType, FigureType.LINE);
        this.points = getPoints();
    }

    public Line(Point startPoint, Point endPoint) {
        this(FigureType.valueOf(new Points().add(startPoint).add(endPoint)));
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

    @Override
    public int compareTo(Line o) {
        return (int)(this.perimeter() - o.perimeter());
    }
}
