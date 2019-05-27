package coordinate.view;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
        private static final String INPUT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)((-)\\(([0-9]+)(,)([0-9]+)\\))+";
        private static final String DELIMITER = "-";

        public static List<String> inputPoints() {
                System.out.println("좌표를 입력하세요.");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                checkValidForm(input);
                return Arrays.asList(input.split(DELIMITER));
        }

        private static void checkValidForm(String input) {
                if (!input.matches(INPUT_REGEX)) {
                        throw new IllegalArgumentException("정상적인 좌표 형식이 아닙니다.");
                }
        }
}
