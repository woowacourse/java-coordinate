package coordinate;

import coordinate.controller.FigureController;
import coordinate.controller.InputViewController;
import coordinate.controller.OutputViewController;
import coordinate.domain.Points;
import coordinate.domain.Triangle;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputViewController inputViewController = new InputViewController(new InputView());
        Points points = inputViewController.inputCoordinates();

        FigureController figureController = new FigureController();

        Triangle triangle = Triangle.create(points);

        OutputViewController outputViewController = new OutputViewController(new OutputView(), triangle);
        outputViewController.printCoordinatesBoard();
        outputViewController.printFigureInfo();
    }

}
