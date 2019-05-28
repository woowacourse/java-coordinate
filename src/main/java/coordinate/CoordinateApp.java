package coordinate;

import coordinate.domain.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateApp {
    private static ShapeFactory shapeFactory = new ShapeFactory();

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private static void start() {
        String consoleInput = InputView.inputCoordinate();
        Points points = PointsFactory.create(consoleInput);
        Shape shape = shapeFactory.create(points);
        OutputView.printCoordinate(points);
        OutputView.printArea(shape);
    }
}
