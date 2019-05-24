package coordinatecalculator.controller;

import coordinatecalculator.model.coordinate.CoordinatePlane;
import coordinatecalculator.model.figure.PlaneFigure;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;


public class MainController {

    public static void main(String[] args) {
        PlaneFigure planeFigure = InputView.createFigure();
        OutputView.printCoordinatePlane(new CoordinatePlane(planeFigure.getCoordinates()));
        OutputView.printFigureArea(planeFigure);
    }
}