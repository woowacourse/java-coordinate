package coordinatecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Board {
    static final int BOARD_X_MIN = 1;
    static final int BOARD_Y_MIN = 1;
    static final int BOARD_X_MAX = 24;
    static final int BOARD_Y_MAX = 24;
    static final String HORIZONTAL_BAR = "―";
    static final String VERTICAL_BAR = "|";
    static final String POINT = " ●";
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

    String getString() {
        SingleLine line;
        StringBuilder sb = new StringBuilder();
        ListIterator iterator = lines.listIterator(lines.size());
        while (iterator.hasPrevious()) {
            line = (SingleLine) iterator.previous();
            sb.append(line.makeString());
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }
}
