package coordinate.controller;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class Main {
        public static void main(String[] args) {
                IShape shape = createShape();
                OutputView.printCoordinate(shape);
                OutputView.printResult(shape);
        }

        static IShape createShape() {
                try {
                        List<Point> points = InputView.inputPoint();
                        return IShape.MAPPING_SHAPE.get(points.size()).apply(points);
                } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                        return createShape();
                }
        }
}
