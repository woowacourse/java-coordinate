package coordinate.controller;

import coordinate.domain.Line;
import coordinate.domain.LineGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateController {
    public static void main(String[] args) {
        String input = InputView.inputCoordinate();

        Line line = LineGenerator.generate(input);

        OutputView.ouputLength(line.length());
    }
}
