package coord.controller;

import coord.model.figure.ConvexPolygonFactory;
import coord.model.figure.Line;
import coord.model.figure.Points;
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
        System.out.println();
        if (points.number() == 2) {
            OutputView.printLengthOfLine(new Line(points));
            return;
        }
        if (points.number() > 2) {
            OutputView.printAreaOfFigure(ConvexPolygonFactory.makeFrom(points));
        }
    }
}