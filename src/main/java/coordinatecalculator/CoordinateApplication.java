package coordinatecalculator;

import coordinatecalculator.domain.Coordinate;
import coordinatecalculator.util.InputManager;

import java.util.List;

public class CoordinateApplication {
    public static void main(String[] args) {
        List<Coordinate> coordinates = InputManager.getCoordinates();
        System.out.println(coordinates.get(0).calculate(coordinates.get(1).getX(), coordinates.get(1).getY()));

    }
}
