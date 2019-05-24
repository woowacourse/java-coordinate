package coordinatecalculator.controller;

import coordinatecalculator.model.CoordinatePlane;
import coordinatecalculator.model.PlaneFigure;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;


public class MainController {

    public static void main(String[] args) {
        double a = 0.0;
        double b = -0.0;


        System.out.println(a == b);
        System.out.println(b);
        PlaneFigure planeFigure = InputView.createFigure();
        OutputView.printCoordinatePlane(new CoordinatePlane(planeFigure.getCoordinates()));
        OutputView.printFigureArea(planeFigure);
    }
}