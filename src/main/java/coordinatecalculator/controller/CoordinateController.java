package coordinatecalculator.controller;

import coordinatecalculator.model.Point;
import coordinatecalculator.model.Points;
import coordinatecalculator.view.InputView;

import java.util.Arrays;

public class CoordinateController {

    public void run(){
        Points points = Points.create();
        generatePoint(points);
    }

    private void generatePoint(Points points) {
        Arrays.stream(InputView.inputCoordinatePoint())
                .forEach(coordinate -> {
                    try{
                        points.addPoint(new Point(coordinate));
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                });
    }


}
