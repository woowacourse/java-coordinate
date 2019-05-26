package coordinatecalculator.view.outputview;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.Line;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class OutputView {
    private static final int LINE_SIZE = 2;
    private static final int TRIANGLE_SIZE = 3;
    private static final int RECTANGLE_SIZE = 4;

    public static void printResult(Figure figure) {
        ConsoleUI.printConsoleUI(figure);
        printArea(figure);
    }

    private static void printArea(Figure figure) {
        Map<Integer, Function<Figure, String>> messageBox = new HashMap<>();
        messageBox.put(LINE_SIZE, OutputView::getLineLength);
        messageBox.put(TRIANGLE_SIZE, OutputView::getArea);
        messageBox.put(RECTANGLE_SIZE, OutputView::getArea);

        System.out.println(messageBox.get(figure.size()).apply(figure));
    }

    private static String getLineLength(Figure figure) {
        return "두 점 사이 거리는 " + ((Line) figure).getLength();
    }

    private static String getArea(Figure figure) {
        return figure.getName() + "의 넓이는 " + figure.area();
    }
}
