package calculator.domain;

/**
 * @author soojinroh
 * @version 1.0 2019-05-22
 */
public class FigureFactory {
    private static final int POINT = 1;
    private static final int LINE = 2;
    private static final int TRIANGLE = 3;
    private static FigureFactory instance = new FigureFactory();

    public static FigureFactory getInstance() {
        return instance;
    }

    private FigureFactory() {}

    public Figure create(Coordinates coordinates) {
        if (coordinates.size() == POINT) {
            return new Point(coordinates);
        }
        if (coordinates.size() == LINE) {
            return new Line(coordinates);
        }
        if (coordinates.size() == TRIANGLE) {
            return new Triangle(coordinates);
        }
        return new Rectangle(coordinates);
    }
}
