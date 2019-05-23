package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class FigureFactory {
    private static FigureFactory instance = new FigureFactory();

    public static FigureFactory getInstance() {
        return instance;
    }

    private FigureFactory() {}

    public Figure create(Coordinates coordinates) {
        if (coordinates.size() == 1) {
            return new Point(coordinates);
        }
        if (coordinates.size() == 2) {
            return new Line(coordinates);
        }
        if (coordinates.size() == 3) {
            return new Triangle(coordinates);
        }
        return new Rectangle(coordinates);
    }
}
