package coordinate;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateApplication {
    public static void main(String[] args) {
        List<Point> points = makeFigure();
        Graph graph = new Graph();
        graph.setPosition(points);
        OutputView.printGraph(graph);
    }

    public static List<Point> makeFigure() {
        try {
            String coordinates = InputView.askCoordinate();
            List<Point> points = PointsGenerator.makePoints(coordinates);
            if (points.size() == 2) {
                Line line = new Line(points);
            }
            if (points.size() == 3) {
                Triangle triangle = new Triangle(points);
            }
            if (points.size() == 4) {
                Rectangle rectangle = new Rectangle(points);
            }
            return points;
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다");
            return makeFigure();
        }

    }
}
