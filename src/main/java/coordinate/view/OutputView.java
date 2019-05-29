package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Message;
import coordinate.domain.Points;

public class OutputView {
    public static void printPoints(Points points) {
        printCoordinatesBoard(points);
    }

    private static void printCoordinatesBoard(Points points) {
        Board board = Board.create();

        board.drawPoints(points, '*');

        System.out.println(board.toString());
    }

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
