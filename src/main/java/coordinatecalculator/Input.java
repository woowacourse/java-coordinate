package coordinatecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BRACKET_START = "(";
    private static final String BRACKET_END = ")";
    private static final String COMMA = ",";
    private static final String DASH = "-";
    private static final String MAYBE_WHITESPACE = "\\s*";
    private static final String MSG_FORM_POINTS;
    private static final String MSG_INPUT_COORD;

    static {
        MSG_INPUT_COORD = "좌표를 입력하세요.";
        MSG_FORM_POINTS = "좌표 값은 괄호로 둘러져 있어야 하며, 쉼표로 구분되어야 합니다.";
    }

    static List<Point> points() {
        List<Point> result = new ArrayList<>();
        String[] temp = splitByDelimiter(inputWithMessage(MSG_INPUT_COORD), DASH);
        for (String raw : temp) {
            try {
                result.add(parsePoint(raw));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return points(); // 재귀
            }
        }
        return result;
    }

    private static String inputWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine().strip();
    }

    private static Point parsePoint(String input) {
        int x;
        int y;
        String[] pair = splitByDelimiter(stripBracket(input), COMMA);
        try {
            x = Integer.parseInt(pair[0]);
            y = Integer.parseInt(pair[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(MSG_FORM_POINTS);
        }
        return new Point(x, y);
    }

    private static String stripBracket(String input) {
        input = input.strip(); // trim()보다는 strip()이 여러모로 더 낫다고 한다.
        if (!(input.startsWith(BRACKET_START) && input.endsWith(BRACKET_END))) {
            throw new IllegalArgumentException(MSG_FORM_POINTS);
        }
        return input.substring(1, input.length() - 1);
    }

    private static String[] splitByDelimiter(String input, String delimiter) {
        final String regex = MAYBE_WHITESPACE + delimiter + MAYBE_WHITESPACE;
        return input.split(regex);
    }

}
