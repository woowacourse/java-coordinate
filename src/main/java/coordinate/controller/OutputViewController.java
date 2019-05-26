package coordinate.controller;

import coordinate.domain.Line;
import coordinate.view.OutputView;

public class OutputViewController {
    private final OutputView outputView;
    private final Line line;

    public OutputViewController(OutputView outputView, Line line) {
        this.outputView = outputView;
        this.line = line;
    }

    public void printFigureInfo() {
        outputView.printDistance(line.calculateDistance());
    }

    public void printCoordinatesBoard() {
        outputView.printCoordinatesBoard(line.getPoints());
    }
}
