package coordinate.controller;

import coordinate.domain.Rectangle;
import coordinate.view.OutputView;

public class OutputViewController {
    private final OutputView outputView;
    private final Rectangle rectangle;

    public OutputViewController(OutputView outputView, Rectangle rectangle) {
        this.outputView = outputView;
        this.rectangle = rectangle;
    }

    public void printFigureInfo() {
        outputView.printArea(rectangle.getArea());
    }

    public void printCoordinatesBoard() {
        outputView.printCoordinatesBoard(rectangle.getPoints());
    }
}
