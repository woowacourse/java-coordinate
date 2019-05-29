package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.Line;
import coordinate.domain.Points;
import coordinate.domain.generator.FigureFactory;
import coordinate.domain.generator.PointsGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApp {
    public static void main(String[] args) {
        Points points = generatePoints();
        Figure figure = FigureFactory.generate(points);
        printResult(figure);
    }

    private static Points generatePoints() {
        try {
            return PointsGenerator.generatePoints(InputView.inputCoordinate());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return generatePoints();
        }
    }

    private static void printResult(final Figure figure) {
        if (figure.getPoints().size() == 2) {
            OutputView.printResult((Line) figure);
            return;
        }
        OutputView.printResult(figure);
    }
}
