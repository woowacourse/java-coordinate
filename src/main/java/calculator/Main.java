package calculator;

import calculator.domain.*;
import calculator.view.UserInputView;
import calculator.view.UserOutputView;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class Main {
    public static void main(String[] args) {
        Figure figure = UserInputView.generaValidatedFigure();
        Canvas canvas = new Canvas().plotCoordinate(figure);

        UserOutputView.outputCanvas(canvas);
        UserOutputView.outputCalculatedResult(figure);
    }
}
