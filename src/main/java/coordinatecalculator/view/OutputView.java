package coordinatecalculator.view;

import coordinatecalculator.model.coordinate.CoordinatePlane;
import coordinatecalculator.model.figure.PlaneFigure;

public class OutputView {
    public static void printCoordinatePlane(CoordinatePlane plane) {
        System.out.println(plane);
    }

    public static void printFigureArea(PlaneFigure figure) {
        System.out.println(figure.getPreMessage() + figure.calculateArea());
    }
}
