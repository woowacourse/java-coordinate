package coordinate;

import coordinate.domain.Point;
import coordinate.domain.PointsCreator;
import coordinate.domain.Shape;
import coordinate.domain.ShapeFactory;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateApp {
    public static void main(String[] args) {
        Shape shape = createShape();
        OutputView.printCoordinate(shape.getPoints());
        OutputView.printArea(shape);
    }

    private static Shape createShape() {
        try {
            List<Point> points = PointsCreator.create(InputView.inputCoordinate());
            return ShapeFactory.create(points);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createShape();
        }
    }
}
