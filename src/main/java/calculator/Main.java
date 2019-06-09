package calculator;

/**
 * @author soojinroh
 * @version 1.0 2019-05-23
 */
public class Main {
    public static void main(String[] args) {
        CoordinateCalculator coordinateCalculator = new CoordinateCalculator();
        coordinateCalculator.makeResultMap();

        if (!coordinateCalculator.isPoint(1)) {
            coordinateCalculator.makeFigure();
        }

        coordinateCalculator.printResultMap();
    }
}
