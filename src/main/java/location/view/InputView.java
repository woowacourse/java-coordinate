package location.view;

import location.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String DASH = "-";
    private static final String COMMA = ",";
    private static final String INPUT_COORDINATE_MSG = "좌표를 입력하세요.";
    private static final String INPUT_NULL_OR_BLANK_MSG = "값을 입력해주세요.";
    private static final String INPUT_WRONG_FORM = "(x1,y1)-(x2,y2)와 같은 형식으로 입력해 주세요.";
    private static final int X = 0;
    private static final int Y = 1;
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String INPUT_EXPRESSION = "(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}";
    private static List<Point> points;

    public static List<Point> inputCoordinate() {
        System.out.println(INPUT_COORDINATE_MSG);
        String input = SCANNER.nextLine();
        return makeCoordinate(input);
    }

    public static List<Point> makeCoordinate(String input) {
        points = new ArrayList<>();
        checkNullEmpty(input);
        checkExpression(input);
        split(input);
        return points;
    }

    private static void checkNullEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_OR_BLANK_MSG);
        }
    }

    private static void checkExpression(String input) {
        Pattern pattern = Pattern.compile(INPUT_EXPRESSION);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_WRONG_FORM);
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
