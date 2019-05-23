package calculator.view;

import calculator.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class UserOutputView {
    private static final String NEW_LINE = "\n";
    private static final String FORMAT_ALIGN_RIGHT = "%2s";
    private static final int MAX_X_SIZE = 24;
    private static final String SINGLE_BLANK = " ";
    private static final String DOUBLE_BLANK = "  ";
    private static final String STAR = " * ";
    private static final String TRIPLE_BLANK = "   ";
    public static final String X_AXIS_MARK = " - ";
    public static final String Y_AXIS_MARK = "|";

    public static void outputMap(Map map) {
        StringBuilder resultMap = new StringBuilder();

        for (int yCoordinate = map.size() - 1; yCoordinate >= 0; yCoordinate--) {
            resultMap.append(String.format(FORMAT_ALIGN_RIGHT, yCoordinate));
            resultMap.append(drawLine(map.getLine(yCoordinate), yCoordinate)).append(NEW_LINE);
        }

        resultMap.append(drawBottomLine());

        System.out.println(resultMap);
    }

    private static String drawLine(MapLine line, int yCoordinate) {
        StringBuilder resultLine = new StringBuilder();

        for (int xCoordinate = 0; xCoordinate < line.size(); xCoordinate++) {
            resultLine.append(drawPoint(line.get(xCoordinate),xCoordinate, yCoordinate));
        }

        return resultLine.toString();
    }

    private static String drawPoint(Boolean point, int xCoordinate, int yCoordinate) {
        if (point) {
            return STAR;
        }
        if (yCoordinate == 0) {
            return X_AXIS_MARK;
        }
        if (xCoordinate == 0) {
            return Y_AXIS_MARK;
        }
        return TRIPLE_BLANK;
    }

    private static String drawBottomLine() {
        StringBuilder bottomLine = new StringBuilder();
        bottomLine.append(DOUBLE_BLANK);

        for (int i = 0; i <= MAX_X_SIZE; i++) {
            bottomLine.append(String.format(FORMAT_ALIGN_RIGHT,i)).append(SINGLE_BLANK);
        }

        return bottomLine.toString();
    }

    public static void outputCalculatedResult(Figure figure) {
        StringBuilder calculatedResult = new StringBuilder();
        calculatedResult.append(figure.getName());
        calculatedResult.append(" ");
        calculatedResult.append(figure.getCalculateTarget());
        calculatedResult.append("은(는) ");
        calculatedResult.append(figure.calculate());

        System.out.println(calculatedResult.toString());
    }

}
