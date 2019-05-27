package coordinate.controller;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
        public static void main(String[] args) {
                IShape shape = makeIShape();
                OutputView.printCoordinate(shape);
                OutputView.printResult(shape);
        }

        private static IShape makeIShape() {
                try {
                        return IShapeCreator.create(InputView.inputPoints());
                } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                        return makeIShape();
                }
        }
}
