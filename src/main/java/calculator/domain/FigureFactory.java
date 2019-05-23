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

    public Figure create(Coordinates points) {
        if (points.size() == 1) {
            return new Point(points);
        }
        if (points.size() == 2) {
            return new Line(points);
        }

        throw new IllegalArgumentException("잘못된 값입니다.");
    }
}
