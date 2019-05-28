package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public abstract class Figure implements Calculate {
    public void checkNotFigure(boolean state, String message) {
        if (state) {
            throw new IllegalArgumentException(message);
        }
    }

    public abstract String getName();

    public abstract String getCalculateTarget();

    abstract void checkFigureCondition();

    abstract Coordinates getCoordinates();
}
