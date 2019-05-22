package calculator.view;

import calculator.domain.Line;
import calculator.domain.Map;
import calculator.domain.Point;
import calculator.domain.Points;

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

    public static void outputMap(Map map) {
        StringBuilder resultMap = new StringBuilder();

        for (int x = map.size() - 1; x >= 0; x--) {
            resultMap.append(String.format(FORMAT_ALIGN_RIGHT, x));
            resultMap.append(drawLine(map.getLine(x))).append(NEW_LINE);
        }

        resultMap.append(drawBottomLine());

        System.out.println(resultMap);
    }


    private static String drawLine(Line line) {
        StringBuilder resultLine = new StringBuilder();

        for (Boolean point : line) {
            resultLine.append(drawPoint(point));
        }

        return resultLine.toString();
    }

    private static String drawPoint(Boolean point) {
        if (point) {
            return STAR;
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
}
