package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class ShapeCalculateFactory {
    private static ShapeCalculateFactory instance = new ShapeCalculateFactory();

    public static ShapeCalculateFactory getInstance() {
        return instance;
    }

    private ShapeCalculateFactory() {}

    public ShapeCalculate create(Points points) {
        if (points.size() == 1) {
            return new OnePointCalculate(points);
        }
        if (points.size() == 2) {
            return new LineCalculate(points);
        }

        throw new IllegalArgumentException("잘못된 값입니다.");
    }
}
