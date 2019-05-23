package coordinatecalculator.controller;

import coordinatecalculator.model.PlaneFigure;
import coordinatecalculator.view.InputView;


public class MainController {

    public static void main(String[] args) {
        PlaneFigure planeFigure = InputView.createFigure();
        System.out.println(planeFigure.resultMessage() + planeFigure.calculateArea());
    }
}