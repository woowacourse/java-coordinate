package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class OnePointCalculate implements ShapeCalculate {
    private final Points points;

    public OnePointCalculate(Points points) {
        this.points = points;
    }

    @Override
    public double calculate() {
        return 0;
    }
}
