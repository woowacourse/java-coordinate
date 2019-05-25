package coordinatecalculator.controller;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.FigureFactory;
import coordinatecalculator.domain.InputVerification;
import coordinatecalculator.domain.Point;
import coordinatecalculator.view.InputView;

import java.util.List;

public class CoordinateCalculatorManager {
    public void run() {
        FigureFactory figureFactory = new FigureFactory();
        Figure figure = figureFactory.create(getValidPoints());
    }

    private List<Point> getValidPoints() {
        return InputVerification.getValidPoints(InputView.inputPoints());
    }
}
