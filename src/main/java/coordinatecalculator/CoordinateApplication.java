package coordinatecalculator;

import coordinatecalculator.domain.Shape;
import coordinatecalculator.factory.ShapeMaker;
import coordinatecalculator.util.OutputManager;

public class CoordinateApplication {
    public static void main(String[] args) {
        Shape shape = ShapeMaker.createShape();

        OutputManager.separateShape(shape);
    }
}
