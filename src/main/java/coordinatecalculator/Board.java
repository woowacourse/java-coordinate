package coordinatecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Board {
    private static final int BOARD_X_MIN = 1;
    private static final int BOARD_Y_MIN = 1;
    private static final int BOARD_X_MAX = 24;
    private static final int BOARD_Y_MAX = 24;
    private static final String VERTICAL_BAR = "|";
    private static final String HORIZONTAL_BAR = "―";
    private static final String CROSS_POINT = "+";
    private static final String POINT = " ●";
    private static final String SPACE = " ";
    private static final String ZERO_POINT = "0";
    private static final String NEW_LINE = "\n";

    final List<SingleLine> lines = new ArrayList<>();

    Board(Figure figure) {
        boolean flip = false;
        for (int i = BOARD_Y_MIN; i <= BOARD_Y_MAX; i++) {
            lines.add(new SingleLine(i, BOARD_X_MAX, BOARD_Y_MAX, flip));
            flip = !flip;
        }
        for (Point point : figure.getPoints()) {
            this.setPoint(point);
        }
    }

    void setPoint(Point point) {
        int x = point.getX() - BOARD_X_MIN;
        int y = point.getY() - BOARD_Y_MIN;
        lines.get(y).write(x, POINT);
    }

    private static String padLeft(String string, int pad) {
        return String.format("%" + pad + "s", string);
    }

    private static String makeHorizontalLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(padLeft(SPACE, Integer.toString(BOARD_Y_MAX).length()));
        sb.append(CROSS_POINT);
        sb.append(HORIZONTAL_BAR.repeat(BOARD_Y_MAX * 2));
        sb.append(NEW_LINE);
        return sb.toString();
    }

    private static String makeXlegend() {
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

    // 클래스 안의 클래스. 실습을 위해 적용.
    class SingleLine {
        private final List<String> xAxis = new ArrayList<>();
        private final int yAxis;
        private final int yAxisLength;
        private final boolean displayNumber;
        private final String SPACE_FULL_WIDTH = "  ";

        SingleLine(int yAxis, int xAxisLength, int yAxisLength, boolean displayNumber) {
            this.yAxis = yAxis;
            this.yAxisLength = Integer.toString(yAxisLength).length();
            this.displayNumber = displayNumber;
            for (int i = 0; i < xAxisLength; i++) {
                this.xAxis.add(SPACE_FULL_WIDTH);
            }
        }

        void write(final int xAxis, final String point) {
            this.xAxis.set(xAxis, point);
        }

        String makeString() {
            final StringBuilder sb = new StringBuilder();
            final String temp = displayNumber ? Integer.toString(yAxis) : "";
            final String start = Board.padLeft(temp, yAxisLength);
            sb.append(start);
            sb.append(Board.VERTICAL_BAR);
            for (String i : xAxis) {
                sb.append(i);
            }
            return sb.toString();
        }
    }
}
