package coordinatecalculator.controller;

import coordinatecalculator.model.*;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CoordinateController {

    public void run() {
        Points points = this.generatePoint();
        OutputView.printCoordinate(points);
        OutputView.printResult(generateFigure(points));
    }

    private Points generatePoint() {
        try {
            Points points = new Points(InputView.inputCoordinatePoint());
            return points;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return generatePoint();
        }
    }

    private Figure generateFigure(Points points) {
        try {
            return FigureFactory.create(points);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            points = this.generatePoint();
            return generateFigure(points);
        }
    }
}
