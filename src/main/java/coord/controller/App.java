package coord.controller;

import coord.model.Figure;
import coord.model.Line;
import coord.model.Points;
import coord.view.CoordinateView;
import coord.view.InputView;
import coord.view.OutputView;

public class App {
    public static void main(String[] argc) {
        try {
            loop();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            loop();
        }
    }

    private static void loop () {
        Points points = InputView.inputCoordinates();
        CoordinateView coordinateView = new CoordinateView(points);
        coordinateView.print();
        if (points.size() == 2) {
            OutputView.printLengthOfLine(new Line(points));
            return;
        }
        OutputView.printAreaOfFigure(Figure.fromPoints(points));


    }
}