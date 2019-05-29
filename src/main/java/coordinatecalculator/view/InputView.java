package coordinatecalculator.view;

import java.util.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "좌표를 입력하세요.";
    private static final String INVALID_INPUT_MESSAGE = "입력된 값이 존재하지 않습니다.";

    public static String inputLocation() {
        System.out.println(INPUT_MESSAGE);

        String input = SCANNER.nextLine();

        validateInput(input);

        return input;
    }

    private static void validateInput(String input) {
        validateNullInput(input);
        validateEmptyInput(input);
    }

    private static void validateNullInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

}
