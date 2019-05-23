package coordinate;

import coordinate.domain.Point;
import coordinate.domain.Shape;
import coordinate.domain.ShapeFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateApp {
    private static ShapeFactory shapeFactory = new ShapeFactory();

    public static void main(String[] args) {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private static void start() {
        List<Point> points = InputView.inputCoordinate();
        Shape shape = shapeFactory.create(points);
        OutputView.printCoordinate(points);
        OutputView.printArea(shape);
    }
}
