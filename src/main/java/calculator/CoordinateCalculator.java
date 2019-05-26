package calculator;

import calculator.domain.Coordinates;
import calculator.domain.Figure;
import calculator.domain.FigureFactory;
import calculator.domain.Map;
import calculator.view.UserInputView;
import calculator.view.UserOutputView;

public class CoordinateCalculator {

    private Coordinates coordinates;
    private Figure figure;
    private Map map;

    public void excuteCoordinateCalculator() {
        try {
            coordinates = UserInputView.generaValidatedCoordinates();
            figure = FigureFactory.getInstance().create(coordinates);
            map = new Map(coordinates);
        } catch(Exception e) {
             excuteCoordinateCalculator();
        }
    }

    public void printCoordinateCalculatorResult() {
        UserOutputView.outputMap(map);
        UserOutputView.outputCalculatedResult(figure);
    }
}
