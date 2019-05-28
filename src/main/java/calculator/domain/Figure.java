package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public abstract class Figure implements Calculate {

    private String name;
    private String calculateTarget;

    public Figure(String name, String calculateTarget) {
        this.name = name;
        this.calculateTarget = calculateTarget;
    }

    public String getName() {
        return this.name;
    }

    public String getCalculateTarget() {
        return calculateTarget;
    }

    public void checkNotFigure(boolean state, String message) {
        if (state) {
            throw new IllegalArgumentException(message);
        }
    }

    abstract void checkFigureCondition();

    abstract Coordinates getCoordinates();
}
