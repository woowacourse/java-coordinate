package coordinate;

import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Vertices;
import coordinate.model.creator.VerticesGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = makeFigure();
        OutputView.printFigurePoints(figure);
    }

    private static Figure makeFigure() {
        try {
            String coordinates = InputView.askCoordinate();
            Vertices vertices = VerticesGenerator.makePoints(coordinates);
            return FigureFactory.getInstance(vertices);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다");
            return makeFigure();
        }

    }
}