package coord.controller;

import coord.model.Figure;
import coord.model.Line;
import coord.model.Points;
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
        final Points points = InputView.inputCoordinates();
        OutputView.printPoints(points);
        if (points.number() == 2) {
            OutputView.printLengthOfLine(new Line(points));
            return;
        }
        OutputView.printAreaOfFigure(Figure.fromPoints(points));
    }
}