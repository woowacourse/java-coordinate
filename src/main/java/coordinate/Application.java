package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.FigureEnum;
import coordinate.domain.Vertices;
import coordinate.domain.VerticesFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            String value = InputView.getPoints();
            Vertices vertices = VerticesFactory.makeVertices(value);
            Figure figure = FigureEnum.figureOf(vertices);
            OutputView.printFigure(figure);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            main(args);
        }

    }
}
