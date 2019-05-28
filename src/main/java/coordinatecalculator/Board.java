package coordinatecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Board {
    static final int BOARD_X_MIN = 1;
    static final int BOARD_Y_MIN = 1;
    static final int BOARD_X_MAX = 24;
    static final int BOARD_Y_MAX = 24;
    static final String VERTICAL_BAR = "|";
    static final String HORIZONTAL_BAR = "―";
    static final String CROSS_POINT = "+";
    static final String POINT = " ●";
    static final String SPACE = " ";
    static final String ZERO_POINT = "0";
    static final String NEW_LINE = "\n";

    final List<SingleLine> lines = new ArrayList<>();

    Board() {
        boolean flip = false;
        for (int i = BOARD_Y_MIN; i <= BOARD_Y_MAX; i++) {
            lines.add(new SingleLine(i, BOARD_X_MAX, BOARD_Y_MAX, flip));
            flip = !flip;
        }
    }

    void setPoint(Point point) {
        int x = point.getX() - BOARD_X_MIN;
        int y = point.getY() - BOARD_Y_MIN;
        lines.get(y).write(x, POINT);
    }

    static String padLeft(String string, int pad) {
        return String.format("%" + pad + "s", string);
    }

    private String makeHorizontalLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(padLeft(SPACE, Integer.toString(BOARD_Y_MAX).length()));
        sb.append(CROSS_POINT);
        sb.append(HORIZONTAL_BAR.repeat(BOARD_Y_MAX * 2));
        sb.append(NEW_LINE);
        return sb.toString();
    }

    private String makeXlegend() {
        int emptyLength = Integer.toString(BOARD_X_MAX).length();
        String empty = padLeft("", emptyLength);
        String temp;
        boolean flip = false;
        StringBuilder sb = new StringBuilder();
        sb.append(padLeft(ZERO_POINT, emptyLength));
        sb.append(SPACE);
        for (int i = BOARD_X_MIN; i <= BOARD_X_MAX; i++) {
            temp = flip ? padLeft(Integer.toString(i), emptyLength) : empty;
            sb.append(temp);
            flip = !flip;
        }
        return sb.toString();
    }

    String getString() {
        SingleLine line;
        StringBuilder sb = new StringBuilder();
        ListIterator iterator = lines.listIterator(lines.size());
        while (iterator.hasPrevious()) {
            line = (SingleLine) iterator.previous();
            sb.append(line.makeString());
            sb.append(NEW_LINE);
        }
        sb.append(makeHorizontalLine());
        sb.append(makeXlegend());
        return sb.toString();
    }
}
