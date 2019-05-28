package coordinatecalculator.controller;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.FigureFactory;
import coordinatecalculator.domain.PointGroup;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.outputview.OutputView;

public class CoordinateCalculatorManager {
    public void run() {
        Figure figure = FigureFactory.create(new PointGroup(InputView.inputPoints()));
        OutputView.printResult(figure);
    }
}