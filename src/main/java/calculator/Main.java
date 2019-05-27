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
        Coordinates coordinates = UserInputView.generaValidatedCoordinates();
        GraphMap graphMap = new GraphMap();

        for (Coordinate coordinate : coordinates) {
            graphMap.plotCoordinate(coordinate);
        }

        Figure figure = new FigureFactory().create(coordinates);
        UserOutputView.outputMap(graphMap);
        UserOutputView.outputCalculatedResult(figure);
    }
}
