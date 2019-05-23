package coordinate.controller;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
        public static void main(String[] args) {
                IShape shape = IShape.createShape(InputView.inputPoint());
                OutputView.printCoordinate(shape);
                OutputView.printResult(shape);
        }
}
