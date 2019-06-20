package coordinatecalculator.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MAYBE_WHITESPACE = "\\s*";
    private static final String MSG_INPUT_COORD = "좌표를 입력하세요.";
    private static final String MSG_FORM_POINTS
            = "좌표 값은 괄호로 둘러져 있어야 하며, 쉼표로 구분되어야 합니다.";
    private static final String BRACKET_START = "(";
    private static final String BRACKET_END = ")";
    private static final String COMMA = ",";
    private static final String DASH = "-";

    private static String inputWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine().strip();
    }

    public static List<String> inputPoints() {
        List<String> result = new ArrayList<>();
        String[] temp = splitByDelimiter(Input.inputWithMessage(MSG_INPUT_COORD), DASH);
        for (String string : temp) {
            String[] pair = splitByDelimiter(stripBracket(string), COMMA);
            result.add(pair[0]);
            result.add(pair[1]);
        }
        return result;
    }

    private static String[] splitByDelimiter(String input, String delimiter) {
        final String regex = MAYBE_WHITESPACE + delimiter + MAYBE_WHITESPACE;
        return input.split(regex);
    }

    private static String stripBracket(String input) {
        input = input.strip(); // trim()보다는 strip()이 여러모로 더 낫다고 한다.
        if (!(input.startsWith(BRACKET_START) && input.endsWith(BRACKET_END))) {
            throw new IllegalArgumentException(MSG_FORM_POINTS);
        }
        return input.substring(1, input.length() - 1);
    }
}
