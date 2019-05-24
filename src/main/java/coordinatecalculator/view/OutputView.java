package coordinatecalculator.view;

import coordinatecalculator.model.coordinate.CoordinatePlane;
import coordinatecalculator.model.figure.PlaneFigure;

public class OutputView {
    public static void printCoordinatePlane(CoordinatePlane plane) {
        System.out.println(plane.getPlane());
    }

    public static void printFigureArea(PlaneFigure figure) {
        System.out.println(figure.resultMessage() + figure.calculateArea());
    }
}
