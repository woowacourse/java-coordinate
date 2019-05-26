package coordinatecalculator.controller;

import coordinatecalculator.model.*;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.OutputView;

public class CoordinateController {
    private Points points;

    public void run() {
        this.points = generatePoint();
        OutputView.showCoordinate(generateFigure(points), this.points);
    }

    private Points generatePoint() {
        try{
            return Points.create(InputView.inputCoordinatePoint());
        } catch (Exception e){
            System.err.println(e.getMessage());
            return generatePoint();
        }
    }

    private Figure generateFigure(Points points){
        try{
            return new FigureFactory().create(points);
        } catch (Exception e){
            System.err.println(e.getMessage());
            this.points = generatePoint();
            return generateFigure(this.points);
        }
    }
}
