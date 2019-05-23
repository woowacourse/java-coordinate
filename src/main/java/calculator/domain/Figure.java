package calculator.domain;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public abstract class Figure implements Calculate{

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

    @Override
    public double straight(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(a.getX()-b.getX(),2) + Math.pow(a.getY() - b.getY(),2));
    }
}
