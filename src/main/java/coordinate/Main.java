package coordinate;

import coordinate.controller.FigureController;
import coordinate.controller.InputViewController;
import coordinate.controller.OutputViewController;
import coordinate.domain.Points;
import coordinate.domain.ResultPrintable;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputViewController inputViewController = new InputViewController(new InputView());
        Points points = inputViewController.inputCoordinates();

        FigureController figureController = new FigureController();
        ResultPrintable resultPrintable = figureController.getFigure(points);

        OutputViewController outputViewController = new OutputViewController(new OutputView(), resultPrintable);
        outputViewController.printCoordinatesBoard(points);
        outputViewController.printFigureInfo();
    }
}
