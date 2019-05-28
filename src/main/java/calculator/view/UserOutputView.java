package calculator.view;

import calculator.domain.*;

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
    private static final String X_AXIS_MARK = " - ";
    private static final String Y_AXIS_MARK = "|  ";
    private static final String IS_MESSAGE = "은(는) ";

    public static void outputCanvas(Canvas canvas) {
        StringBuilder resultMap = new StringBuilder();

        for (int yCoordinate = canvas.size() - 1; yCoordinate >= 0; yCoordinate--) {
            resultMap.append(String.format(FORMAT_ALIGN_RIGHT, yCoordinate));
            resultMap.append(plotLine(canvas.getMapLine(yCoordinate), yCoordinate)).append(NEW_LINE);
        }

        resultMap.append(plotBottomLine());

        System.out.println(resultMap);
    }

    private static String plotLine(CanvasLine canvasLine, int yCoordinate) {
        StringBuilder resultLine = new StringBuilder();

        for (int xCoordinate = 0; xCoordinate < canvasLine.size(); xCoordinate++) {
            resultLine.append(plotCoordinate(canvasLine.get(xCoordinate), xCoordinate, yCoordinate));
        }

        return resultLine.toString();
    }

    private static String plotCoordinate(Boolean coordinate, int xCoordinate, int yCoordinate) {
        if (coordinate) {
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

    private static String plotBottomLine() {
        StringBuilder bottomLine = new StringBuilder();
        bottomLine.append(DOUBLE_BLANK);

        for (int i = 0; i <= MAX_X_SIZE; i++) {
            bottomLine.append(String.format(FORMAT_ALIGN_RIGHT, i)).append(SINGLE_BLANK);
        }

        return bottomLine.toString();
    }

    public static void outputCalculatedResult(Figure figure) {
        StringBuilder calculatedResult = new StringBuilder();
        calculatedResult.append(figure.getName());
        calculatedResult.append(SINGLE_BLANK);
        calculatedResult.append(figure.getCalculateTarget());
        calculatedResult.append(IS_MESSAGE);
        calculatedResult.append(figure.area());

        System.out.println(calculatedResult.toString());
    }

}
