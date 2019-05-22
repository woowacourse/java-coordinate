package location.view;

import location.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String DASH = "-";
    private static final String COMMA = ",";
    private static final String INPUT_COORDINATE_MSG = "좌표를 입력하세요.";
    private static final String INPUT_NULL_OR_BLANK_MSG = "값을 입력해주세요.";
    private static final int X = 0;
    private static final int Y = 1;
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    private static List<Point> points;

    public static List<Point> inputCoordinate() {
        System.out.println(INPUT_COORDINATE_MSG);
        String input = SCANNER.nextLine();
        return makeCoordinate(input);
    }

    public static List<Point> makeCoordinate(String input) {
        points = new ArrayList<>();
        isValid(input);
        split(input);
        return points;
    }

    private static void isValid(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_OR_BLANK_MSG);
        }
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
