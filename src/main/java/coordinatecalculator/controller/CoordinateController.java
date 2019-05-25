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
        OutputView.printResult(FigureFactory.create(points));
    }

    private Points generatePoint() {
        Points points = Points.create();
        String[] scannedPoints = InputView.inputCoordinatePoint();
        for (String point : scannedPoints) {
            try {
                points.addPoint(new Point(point));
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return generatePoint();
            }
        }
        return points;
    }
}
