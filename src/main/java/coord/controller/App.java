package coord.controller;

import coord.model.figure.ConvexPolygon;
import coord.model.Line;
import coord.model.Points;
import coord.view.InputView;
import coord.view.OutputView;

public class App {
    public static void main(String[] argc) {
        try {
            app();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void app () {
        final Points points = InputView.inputCoordinates();
        OutputView.printScreen(points);
        if (points.number() == 2) {
            OutputView.printLengthOfLine(new Line(points));
            return;
        }
        OutputView.printAreaOfFigure(ConvexPolygon.getConvexPolygon(points));
    }
}