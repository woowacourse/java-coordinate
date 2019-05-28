package calculator;

import calculator.domain.Coordinates;
import calculator.domain.Figure;
import calculator.domain.FigureFactory;
import calculator.domain.ResultMap;
import calculator.view.UserInputView;
import calculator.view.UserOutputView;

public class CoordinateCalculator {

    private Coordinates coordinates;
    private Figure figure;
    private ResultMap map;

    public void makeResultMap() {
        try {
            coordinates = UserInputView.generaValidatedCoordinates();
            map = new ResultMap(coordinates);
        } catch(Exception e) {
             makeResultMap();
        }
    }

    public void makeFigure() {
        try {
            figure = FigureFactory.create(coordinates);
        } catch(Exception e) {
            makeResultMap();
            makeFigure();
        }
    }

    public void printResultMap() {
        UserOutputView.outputMap(map);
        if (coordinates.size() != 1) {
            UserOutputView.outputCalculatedResult(figure);
        }
    }

    public boolean isPoint(int coordinatesSize) {
        return coordinates.size() == coordinatesSize;
    }
}
