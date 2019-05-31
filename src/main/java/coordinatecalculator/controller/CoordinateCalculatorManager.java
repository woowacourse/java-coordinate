package coordinatecalculator.controller;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.FigureFactory;
import coordinatecalculator.domain.Point;
import coordinatecalculator.domain.PointGroup;
import coordinatecalculator.view.inputview.InputView;
import coordinatecalculator.view.inputview.PointParser;
import coordinatecalculator.view.outputview.OutputView;

import java.util.List;

public class CoordinateCalculatorManager {
    public void run() {
        PointGroup pointGroup = new PointGroup(PointParser.getValidPoints(InputView.inputPoints()));
        Figure figure = FigureFactory.create(pointGroup);
        OutputView.printResult(figure, pointGroup);
    }
}