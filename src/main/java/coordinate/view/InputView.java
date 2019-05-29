package coordinate.view;

import coordinate.utils.InputSplitter;

import java.util.*;

public class InputView {
    private static final String DEFAULT_DELIMITERS = "\\([0-9]{1,2},[0-9]{1,2}\\)";

    public static List<String> InputPoints() {
        try {
            System.out.println("좌표를 입력하세요");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            return checkValidFormat(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputPoints();
        }
    }

    static List<String> checkValidFormat(String input) {
        List<String> points = convertPoint(InputSplitter.getSplit(input, "-"));
        for (String point : points) {
            isValidFormat(point);
        }
        return points;
    }

    private static List<String> convertPoint(List<String> points) {
        points.stream().forEach(c -> isValidFormat(c));
        return points;
    }


    private static void isValidFormat(String points) {
        if (!points.matches(DEFAULT_DELIMITERS)) {
            throw new IllegalArgumentException("올바른 형식을 입력하세요.");
        }
    }

}
