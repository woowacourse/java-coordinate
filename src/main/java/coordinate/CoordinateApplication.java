package coordinate;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateApplication {
    public static void main(String[] args) {
        Figure figure = makeFigure();
        Graph graph = new Graph(figure);
        graph.markPointsPositions();
        OutputView.printResult(graph, figure);
    }

    public static Figure makeFigure() {
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
