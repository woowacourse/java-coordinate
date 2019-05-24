package coordinatecalculator.view;

import coordinatecalculator.domain.Drawer;
import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class OutputView {
    public static void printResult(Figure figure) {
        List<StringBuilder> board = Drawer.newInstance(figure.getPoints()).getBoard();
        for (int i = 0; i < board.size(); i++) {
            System.out.print(board.get(i).toString());
        }

    }
}
