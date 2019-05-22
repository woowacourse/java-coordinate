package coordinate.view;

import coordinate.domain.Figure;

public class OutputView {
    public static void printResult(Figure figure) {
        System.out.println(figure.getResultMessage() + figure.calculateResult());
    }
}
