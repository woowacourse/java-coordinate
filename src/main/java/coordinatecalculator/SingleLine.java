package coordinatecalculator;

import java.util.ArrayList;
import java.util.List;

class SingleLine {
    private final List<String> xAxis = new ArrayList<>();
    //    private final int xAxisLength;
    private final int yAxis;
    private final int yAxisLength;
    private final boolean displayNumber;

    SingleLine(int yAxis, int xAxisLength, int yAxisLength, boolean displayNumber) {
        //        this.xAxisLength = xAxisLength;
        this.yAxis = yAxis;
        this.yAxisLength = Integer.toString(yAxisLength).length();
        this.displayNumber = displayNumber;
        for (int i = 0; i < xAxisLength; i++) {
            this.xAxis.add("  ");
        }
    }

    //    int getYaxis() {
    //        return this.yAxis;
    //    }

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
