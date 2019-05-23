package coordinatecalculator.controller;

import coordinatecalculator.domain.parent.Figure;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Figure figure = InputView.inputLocation();

        OutputView.drawGraph(figure);
        OutputView.printResult(figure);
    }
}
