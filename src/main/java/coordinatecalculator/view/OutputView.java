package coordinatecalculator.view;

import coordinatecalculator.domain.Drawer;
import coordinatecalculator.domain.parent.Console;
import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class OutputView {
    public static void printResult(Figure figure) {
        Drawer drawer = new Drawer(figure.getPoints());
        List<StringBuilder> board = drawer.getBoard();
        for (StringBuilder oneLine : board) {
            System.out.print(oneLine.toString());
        }
        System.out.println(((Console)figure).makeResult());
    }
}
