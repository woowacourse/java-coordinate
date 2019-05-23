package coordinatecalculator.view;

import coordinatecalculator.domain.FigureRouter;
import coordinatecalculator.domain.parent.Figure;
import coordinatecalculator.util.PointsGenerator;

import java.util.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MESSSAGE = "좌표를 입력하세요.";

    public static Figure inputLocation() {
        System.out.println(INPUT_MESSSAGE);
        return FigureRouter.routing(PointsGenerator.create(SCANNER.nextLine()));
    }
}
