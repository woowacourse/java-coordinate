package coordinate.controller;

import coordinate.domain.Triangle;
import coordinate.view.OutputView;

public class OutputViewController {
    private final OutputView outputView;
    private final Triangle triangle;

    public OutputViewController(OutputView outputView, Triangle triangle) {
        this.outputView = outputView;
        this.triangle = triangle;
    }

    public void printFigureInfo() {
        outputView.printTriangleArea(triangle.getArea());
    }

    public void printCoordinatesBoard() {
        outputView.printCoordinatesBoard(triangle.getPoints());
    }
}
