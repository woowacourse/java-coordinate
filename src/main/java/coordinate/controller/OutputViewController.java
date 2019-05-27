package coordinate.controller;

import coordinate.domain.Points;
import coordinate.domain.ResultPrintable;
import coordinate.view.OutputView;

public class OutputViewController {
    private final OutputView outputView;
    private final ResultPrintable resultPrintable;

    public OutputViewController(OutputView outputView, ResultPrintable resultPrintable) {
        this.outputView = outputView;
        this.resultPrintable = resultPrintable;
    }

    public void printFigureInfo() {
        outputView.printResult(resultPrintable.getResultMessage());
    }

    public void printCoordinatesBoard(Points points) {
        outputView.printCoordinatesBoard(points);
    }
}
