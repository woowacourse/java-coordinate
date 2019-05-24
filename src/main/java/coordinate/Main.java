package coordinate;

import coordinate.model.*;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Shape shape = createShape();
        OutputView.printCoordinate(shape);
        OutputView.printResult(shape);
    }

    private static Shape createShape() {
        try {
            StringToPointConverter converter = new StringToPointConverter(InputView.inputPoint());
            return ShapeFactory.create(converter.generate());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createShape();
        }
    }
}
