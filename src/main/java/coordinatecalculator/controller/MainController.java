package coordinatecalculator.controller;

import coordinatecalculator.model.coordinate.CoordinatePlane;
import coordinatecalculator.model.figure.PlaneFigure;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;


public class MainController {

    public static void main(String[] args) {
        PlaneFigure figure = InputView.createFigure();
        CoordinatePlane plane = new CoordinatePlane();

        plane.pointCoordinates(figure.getCoordinates());

        OutputView.printCoordinatePlane(plane);
        OutputView.printFigureArea(figure);
    }
}