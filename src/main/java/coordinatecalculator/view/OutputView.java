package coordinatecalculator.view;

import coordinatecalculator.domain.Drawer;
import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class OutputView {
    public static void printResult(Figure figure) {
        System.out.println(figure.getClass());
        List<StringBuilder> board = Drawer.newInstance(figure.getPoints()).getBoard();

        for (StringBuilder resultLine : board) {
            System.out.println(resultLine.toString());
        }

        System.out.printf("%s의 %s는 %f입니다.\n", figure.getName(), figure.getResultType(), figure.calculateResult());
    }
}
