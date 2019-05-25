package location.domain;

import java.util.ArrayList;
import java.util.List;

public class PointMaker {
    private static final String DASH = "-";
    private static final String COMMA = ",";
    private static final int X = 0;
    private static final int Y = 1;
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static List<Point> points;

    public static List<Point> create(String input) {
        points = new ArrayList<>();
        split(input);
        return points;
    }

    private static void split(String input) {
        for (String splitBlockByDash : splitByDash(input)) {
            String[] splitBlockByComma = splitByComma(splitBlockByDash);
            addPoint(splitBlockByComma);
        }
    }

    private static String[] splitByDash(String input) {
        return input.split(DASH);
    }

    private static String[] splitByComma(String splitByDash) {
        return splitByDash.split(COMMA);
    }

    private static void addPoint(String[] splitBlockByComma) {
        int x = parseInt(splitBlockByComma[X], LEFT_PARENTHESIS);
        int y = parseInt(splitBlockByComma[Y], RIGHT_PARENTHESIS);
        points.add(new Point(x, y));
    }

    private static int parseInt(String splitBlockByComma, String target) {
        return Integer.parseInt(splitBlockByComma.replace(target, ""));
    }
}
