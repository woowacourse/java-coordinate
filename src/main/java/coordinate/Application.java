package coordinate;

import coordinate.domain.Figure;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Figure figure = InputView.getFigure();
        OutputView.printFigure(figure);
    }
}
