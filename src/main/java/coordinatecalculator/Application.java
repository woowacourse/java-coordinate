package coordinatecalculator;

import coordinatecalculator.controller.CoordinateCalculatorManager;

public class Application {
    public static void main(String[] args) {
        CoordinateCalculatorManager coordinateCalculatorManager = new CoordinateCalculatorManager();
        coordinateCalculatorManager.run();
    }
}
