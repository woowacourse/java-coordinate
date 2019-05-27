package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {
    private static final int LEN_DIGITS = 2;
    private static final int MAX_NUM = 24;
    private static final int VERTICAL_START = 1;
    private static final int HORIZON_START = LEN_DIGITS;

    private final List<List<Character>> board;

    private Board(List<List<Character>> board) {
        this.board = board;
    }

    public static Board create() {
        List<List<Character>> board = initBoard();

        drawVerticalLine(board);
        drawHorizontalLine(board);
        drawZero(board);

        return new Board(board);
    }

    private static List<List<Character>> initBoard() {
        return Stream.generate(() -> Stream.generate(() -> ' ')
                .limit(LEN_DIGITS * (2 + (MAX_NUM + 1)))
                .collect(Collectors.toList())).limit(1 + (MAX_NUM + 1)).collect(Collectors.toList());
    }

    private static void set(List<List<Character>> board, int r, int c, char ch) {
        List<Character> line = board.get(r);
        line.set(c, ch);
    }

    private static void drawVerticalLine(List<List<Character>> board) {
        for (int r = 0; r <= MAX_NUM; r++) {
            set(board, VERTICAL_START + r, HORIZON_START, '|');
        }

        for (int r = 2; r <= MAX_NUM; r += 2) {
            int num = r;

            for (int i = LEN_DIGITS - 1; 0 <= i; i--, num /= 10) {
                if (num == 0) {
                    break;
                }
                set(board, VERTICAL_START + r, i, (char) ('0' + (num % 10)));
            }
        }
    }

    private static void drawHorizontalLine(List<List<Character>> board) {
        for (int c = 0; c <= MAX_NUM; c++) {
            for (int i = 0; i < LEN_DIGITS; i++) {
                set(board, VERTICAL_START, HORIZON_START + (c * LEN_DIGITS) + i, '-');
            }
        }

        for (int c = 2; c <= MAX_NUM; c += 2) {
            int num = c;
            for (int i = LEN_DIGITS - 1; 0 <= i; i--, num /= 10) {
                if (num == 0) {
                    break;
                }
                set(board, VERTICAL_START - 1, HORIZON_START + (c * LEN_DIGITS) + i, (char) ('0' + (num % 10)));
            }
        }
    }

    private static void drawZero(List<List<Character>> board) {
        set(board, 0, 0, '0');
        set(board, VERTICAL_START, HORIZON_START, '+');
    }

    public void drawPoints(Points points, char ch) {
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            set(board, VERTICAL_START + p.getY(), HORIZON_START + (LEN_DIGITS * p.getX()), ch);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = board.size() - 1; 0 <= r; r--) {
            for (Character ch : board.get(r)) {
                sb.append(ch);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
