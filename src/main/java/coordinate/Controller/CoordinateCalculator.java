package coordinate.Controller;

import coordinate.domain.PointFactory;
import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateCalculator {
    public static void main(String[] args) {
        Figure figure = getFigure(InputView.InputPoints());
        OutputView.printPoints(figure.getPoints());
        OutputView.printResult(figure);
    }

    private static Figure getFigure(List<String> inputPoints) {
        try {
            return FigureFactory.generateFigure(PointFactory.generatePoints(inputPoints));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getFigure(InputView.InputPoints());
        }
    }
}
