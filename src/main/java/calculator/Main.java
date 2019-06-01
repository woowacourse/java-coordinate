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
        AbstractFigure abstractFigure = UserInputView.generaValidatedFigure();
        Canvas canvas = new Canvas().plotCoordinate(abstractFigure);

        UserOutputView.outputCanvas(canvas);
        UserOutputView.outputCalculatedResult(abstractFigure);
    }
}
