package coordinatecalculator;

import coordinatecalculator.domain.FigureType;
import coordinatecalculator.domain.parent.Figure;
import coordinatecalculator.util.PointsGenerator;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Figure figure = FigureType.routing(PointsGenerator.create(InputView.inputLocation()));

        OutputView.printResult(figure);
    }
}
