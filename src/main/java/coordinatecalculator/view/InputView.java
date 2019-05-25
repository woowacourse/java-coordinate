package coordinatecalculator.view;

import coordinatecalculator.domain.FigureRouter;
import coordinatecalculator.domain.parent.Figure;
import coordinatecalculator.util.PointsGenerator;

import java.util.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "좌표를 입력하세요.";

    public static Figure inputLocation() {
        try {
            System.out.println(INPUT_MESSAGE);
            return FigureRouter.routing(PointsGenerator.create(SCANNER.nextLine()));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLocation();
        }
    }
}
