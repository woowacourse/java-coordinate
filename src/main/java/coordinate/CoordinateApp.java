package coordinate;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.Shape;
import coordinate.domain.ShapeFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateApp {
    public static void main(String[] args) {
        List<Point> points = InputView.intputCoordinate();
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.create(points);
        OutputView.printCoordinate(points);
        OutputView.printArea(shape);
    }
}
