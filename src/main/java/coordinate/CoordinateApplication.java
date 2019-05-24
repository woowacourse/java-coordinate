package coordinate;

import coordinate.model.creator.PointsGenerator;
import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Point;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = makeFigure();
        OutputView.printFigurePoints(figure);
    }

    private static Figure makeFigure() {
        try {
            String coordinates = InputView.askCoordinate();
            List<Point> points = PointsGenerator.makePoints(coordinates);

            return FigureFactory.getInstance(points);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다");
            return makeFigure();
        }

    }
}
