package calculator.domain.figure;

/**
 * @author soojinroh
 * @version 1.0 2019-05-23
 */
public abstract class Figure implements Calculate{

    private String name;
    private String calculateTarget;

    public Figure(String name, String calculateTarget) {
        this.name = name;
        this.calculateTarget = calculateTarget;
    }

    @Override
    public double straight(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(a.getXCoordinate()-b.getXCoordinate(),2) + Math.pow(a.getYCoordinate() - b.getYCoordinate(),2));
    }

    public String getName() {
        return this.name;
    }

    public String getCalculateTarget() {
        return calculateTarget;
    }

}
