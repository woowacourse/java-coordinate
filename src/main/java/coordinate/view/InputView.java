package coordinate.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputCoordinate() {
        try {
            return parse(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputCoordinate();
        }
    }

    private static List<String> split(String text) {
        return Arrays.asList(text.split("-"));
    }

    private static List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String text : split(input)) {
            text = text.replace("(", "").replace(")", "");
            Arrays.stream(text.split(",")).forEach(n -> numbers.add(Integer.parseInt(n)));
        }
        return numbers;
    }
}
