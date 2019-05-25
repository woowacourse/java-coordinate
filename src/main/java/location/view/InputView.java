package location.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_COORDINATE_MSG = "좌표를 입력하세요.";
    private static final String INPUT_NULL_OR_BLANK_MSG = "값을 입력해주세요.";
    private static final String INPUT_WRONG_FORM = "(x1,y1)-(x2,y2)와 같은 형식으로 입력해 주세요.";
    private static final String INPUT_EXPRESSION = "(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}";

    public static String inputCoordinate() {
        try {
            System.out.println(INPUT_COORDINATE_MSG);
            String input = SCANNER.nextLine();
            return checkValid(input);
        } catch (Exception e) {
            return inputCoordinate();
        }
    }

    public static String checkValid(String input) {
        checkNullEmpty(input);
        checkExpression(input);
        return input;
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
}
