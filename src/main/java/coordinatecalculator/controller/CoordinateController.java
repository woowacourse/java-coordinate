package coordinatecalculator.controller;

import coordinatecalculator.model.*;
import coordinatecalculator.view.InputValidator;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CoordinateController {

    public void run(){
        Points points = generatePoints(InputView.inputCoordinatePoint());
        OutputView.printCoordinate(points);
        OutputView.printResult(generateFigure(points));
    }

    private Points generatePoints(String[] scannedPoints) {
        try {
            List<Point> points=new ArrayList<>();
            Arrays.stream(scannedPoints).forEach(scannedPoint -> points.add(generatePoint(scannedPoint)));
            return new Points(points);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return generatePoints(InputView.inputCoordinatePoint());
        }
    }

    private Point generatePoint(String scannedPoint) {
        if (InputValidator.isValidPoint(scannedPoint)) {
            return new Point(
                    generateCoordinate(InputValidator.findPointX(scannedPoint)),
                    generateCoordinate(InputValidator.findPointY(scannedPoint)));
        }
        throw new IllegalArgumentException("잘못된 점 입력입니다.");
    }

    private Coordinate generateCoordinate(String scannedCoordiante) {

        if (InputValidator.isValidCoordinate(scannedCoordiante)) {
            return new Coordinate(Integer.parseInt(scannedCoordiante));
        }
        throw new IllegalArgumentException("잘못된 좌표 입력입니다.");
    }

    private Figure generateFigure(Points points) {
        try {
            FigureCreator figureCreator = new FigureFactory();
            return figureCreator.create(points);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            points = generatePoints(InputView.inputCoordinatePoint());
            return generateFigure(points);
        }
    }
}
