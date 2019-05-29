package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.PointFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;


public class Main {
    private static final int xBegin = 0;
    private static final int xEnd = 25;
    private static final int yBegin = 0;
    private static final int yEnd = 25;

    private static final PointFactory POINT_FACTORY = PointFactory.of(xBegin, xEnd, yBegin, yEnd);

    public static void main(String[] args) {

        Figure figure = InputView.readFigure(POINT_FACTORY);

        OutputView.printFigurePoints(figure);
        OutputView.printMessage(figure);
    }
}
