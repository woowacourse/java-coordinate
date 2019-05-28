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
        GraphMap graphMap = new GraphMap().plotCoordinate(figure);

        UserOutputView.outputMap(graphMap);
        UserOutputView.outputCalculatedResult(figure);
    }
}
