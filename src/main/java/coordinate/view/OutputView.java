package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Points;

import java.util.HashMap;
import java.util.Map;

import static coordinate.view.UserInterface.MAX_INDEX;
import static coordinate.view.UserInterface.MIN_INDEX;

public class OutputView {
    private static final String POLE_HEIGHT = "|";
    private static final String NEW_LINE = "\n";
    private static final String X_AXIS = "-----------------------------------------------------------------------------";
    private static final String X_NUMBERS = "0     2     4     6     8     10    12    14    16    18    20    22";
    private static final Map<Integer, FigurePrintor> printer = new HashMap<>();

    static {
        printer.put(2, figure -> System.out.printf("두 점 사이 거리는 %.1f\n", figure.length()));
        printer.put(3, figure -> System.out.printf("삼각형의 넓이는 %.1f\n", figure.area()));
        printer.put(4, figure -> System.out.printf("사각형의 넓이는 %.1f\n", figure.area()));
    }

    public static void printResult(final Figure figure) {
        Points figurePoints = figure.getPoints();
        printCoordinates(figurePoints);
        printer.get(figurePoints.size()).printResult(figure);
    }

    private static void printCoordinates(final Points points) {
        UserInterface userInterface = new UserInterface();
        userInterface.drawPoints(points);
        StringBuilder sb = new StringBuilder();
        Board board = userInterface.getBoard();
        drawBoard(sb, board);
        System.out.println(sb.toString());
    }

    private static void drawBoard(final StringBuilder sb, final Board board) {
        for (int y = MAX_INDEX - 1; y >= MIN_INDEX; y--) {
            Row row = board.getRow(y);
            sb.append(y).append(POLE_HEIGHT);
            drawRow(sb, row);
            sb.append(NEW_LINE);
        }
        sb.append(X_AXIS).append(NEW_LINE);
        sb.append(X_NUMBERS);
    }

    private static void drawRow(final StringBuilder sb, final Row row) {
        for (int x = MIN_INDEX; x < MAX_INDEX; x++) {
            sb.append(row.getCoordinate(x) ? "*  " : "   ");
        }
    }
}
