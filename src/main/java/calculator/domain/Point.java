package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Point extends Figure{
    private final Coordinates points;

    public Point(Coordinates points) {
        super("한 점", "길이");
        this.points = points;
    }

    @Override
    public double calculate() {
        return 0;
    }
}
