package coordinatecalculator;

import coordinatecalculator.model.*;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

public class CoordinateLauncher {
    public static void main(String[] args) {
        Figure figure = generateFigure();
        Graph graph = new Graph(figure);
        OutputView.printResult(graph, figure);
    }

    private static Figure generateFigure() {
        try {
            String points = InputView.askPoints();
            Points figurePoints = PointsFactory.generatePoints(points);
            return FigureFactory.generateFigure(figurePoints);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다");
            return generateFigure();
        }
    }
}
