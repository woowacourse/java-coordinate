package coordinate.controller;

import coordinate.domain.*;
import coordinate.view.input.InputView;

public class Main {
    public static void main(String[] args) {
        Points points = PointsGenerator.generator(InputView.inputPoints());
        Lines lines = LinesGenerator.generator(points);


        for (Line line : lines.getLines()) {
            System.out.println(line);
        }
    }
}
