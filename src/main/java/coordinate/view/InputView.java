package coordinate.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NUM_ERR = "좌표는 숫자여야 합니다.";
    private static final String GUIDE_COORDINATE = "좌표를 입력하세요.";
    private static final String BRACE_OPEN = "(";
    private static final String BRACE_CLOSE = ")";
    private static final String DELIMETER_FIRST = "-";
    private static final String DELIMETER_SECOND = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputCoordinate() {
        System.out.println(GUIDE_COORDINATE);
        try {
            return parse(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println(NUM_ERR);
            return inputCoordinate();
        }
    }

    private static List<String> split(String text) {
        return Arrays.asList(text.split(DELIMETER_FIRST));
    }

    private static List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String text : split(input)) {
            text = text.replace(BRACE_OPEN, "").replace(BRACE_CLOSE, "");
            Arrays.stream(text.split(DELIMETER_SECOND)).forEach(n -> numbers.add(Integer.parseInt(n)));
        }

        return numbers;
    }
}
