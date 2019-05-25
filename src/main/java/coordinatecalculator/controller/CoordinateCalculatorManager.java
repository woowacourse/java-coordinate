package coordinatecalculator.controller;

import coordinatecalculator.domain.InputVerification;
import coordinatecalculator.domain.PointsManager;
import coordinatecalculator.view.InputView;

public class CoordinateCalculatorManager {
    public void run() {
        PointsManager.createPoints(InputVerification.getValidPoints(InputView.inputPoints()));
    }
}
