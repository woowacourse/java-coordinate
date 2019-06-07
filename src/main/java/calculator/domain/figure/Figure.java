package calculator.domain.figure;

/**
 * @author soojinroh
 * @version 1.0 2019-05-23
 */
public abstract class Figure implements Calculate{
    @Override
    public double straight(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(a.getXCoordinate()-b.getXCoordinate(),2) + Math.pow(a.getYCoordinate() - b.getYCoordinate(),2));
    }
}
