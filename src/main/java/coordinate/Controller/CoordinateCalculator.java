package coordinate.Controller;

import coordinate.domain.PointList;
import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateCalculator {
    public static void main(String[] args) {
        PointList points = InputView.InputPoints();
        Figure figure = getFigure(points);
        OutputView.printPoints(points);
        OutputView.printResult(figure);
    }

    private static Figure getFigure(PointList points) {
        try {
            return FigureFactory.generateFigure(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getFigure(InputView.InputPoints());
        }
    }
}
