package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.domain.PointGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Figure figure = FigureFactory.figure(PointGenerator.trans(InputView.inputCoordinate()));
        OutputView.print(figure);
    }
}
