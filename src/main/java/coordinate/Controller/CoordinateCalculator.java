package coordinate.Controller;

import coordinate.domain.PointList;
import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateCalculator {
    public static void main(String[] args) {
        executeCoordinateCalculator();
    }

    private static void executeCoordinateCalculator() {
        PointList pointList = InputView.InputPoints();
        Figure figure;
        try {
            figure = FigureFactory.generateFigure(pointList);
            OutputView.printPoints(pointList);
            OutputView.printResult(figure);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            executeCoordinateCalculator();
            return;
        }
    }
}
