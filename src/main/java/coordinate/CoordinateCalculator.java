package coordinate;

import coordinate.domain.Line;
import coordinate.domain.ShapeGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateCalculator {
    public static void main(String[] args) {
        Line line = generateLine();
        OutputView.printDistance(line.length());
    }

    private static Line generateLine() {
        try {
            return new ShapeGenerator(InputView.inputCoordinate()).generateLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLine();
        }
    }
}
