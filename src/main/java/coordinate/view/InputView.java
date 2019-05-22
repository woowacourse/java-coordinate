package coordinate.view;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)((-)\\(([0-9]+)(,)([0-9]+)\\))*";

    public static List<String> inputPoint() {
        try {
            System.out.println("좌표를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            String inputs = scanner.nextLine();
            checkValidForm(inputs);
            return Arrays.asList(inputs.split("-"));
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputPoint();
        }
    }

    private static void checkValidForm(String text) {
        if (!text.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException("정상적인 좌표 형식이 아닙니다.");
        }
    }
}
