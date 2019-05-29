package coordinatecalculator;

import coordinatecalculator.domain.FigureRouter;
import coordinatecalculator.domain.parent.Figure;
import coordinatecalculator.util.PointsGenerator;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Figure figure = FigureRouter.routing(PointsGenerator.create(InputView.inputLocation()));

        OutputView.printResult(figure);
    }
}
