package coordinatecalculator;

import coordinatecalculator.domain.Coordinate;
import coordinatecalculator.util.InputManager;
import coordinatecalculator.util.OutputView;

import java.util.List;

public class CoordinateApplication {
    public static void main(String[] args) {
        List<Coordinate> coordinates = InputManager.getCoordinates();
        OutputView.printDistanceBetweenTwoPoints(coordinates.get(0).calculate(coordinates.get(1)));
    }
}
