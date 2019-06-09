package calculator;

import calculator.domain.figure.Coordinates;
import calculator.domain.figure.Figure;
import calculator.domain.figure.FigureFactory;
import calculator.domain.map.ResultMap;
import calculator.view.UserInputView;
import calculator.view.UserOutputView;

public class CoordinateCalculator {

    private Coordinates coordinates;
    private Figure figure;
    private ResultMap map;

    public void makeResultMap() {
        try {
            coordinates = UserInputView.generateValidatedCoordinates();
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
            UserOutputView.outputCalculatedResult(coordinates.size(), figure);
        }
    }

    public boolean isPoint(int coordinatesSize) {
        return coordinates.size() == coordinatesSize;
    }
}
