package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.FigureEnum;
import coordinate.domain.VerticesFactory;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GET_COORDINATE_MESSAGE = "좌표를 입력하세요.";

    public static Figure getFigure() {
        try {
            OutputView.printMessage(GET_COORDINATE_MESSAGE);
            return FigureEnum.figureOf(VerticesFactory.makeVertices(getUserInput()));
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getFigure();
        }
    }

    private static String getUserInput() {
        return SCANNER.nextLine();
    }

}
