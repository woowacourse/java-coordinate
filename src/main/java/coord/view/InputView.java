package coord.view;

import coord.model.Point;
import coord.model.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner input = new Scanner(System.in);
    private static final String delimeter = "-";
    private static final String validator = "\\([ ]*[0-9]+[ ]*,[ ]*[0-9]+[ ]*\\)";
    private static final String braces = "\\(|,|\\)";

    public static Points inputCoordinates() {
        System.out.println(ConsoleMessages.INPUT_COORDINATE.message());
        try {
            return parseCoordinates(input.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static Points parseCoordinates(String input) {
        List<String> tokens = validateTokens(Arrays.asList(input.split(delimeter)));
        try {
            return new Points(
                    IntStream.iterate(0, i -> i + 2)
                            .limit(tokens.size() / 2).boxed()
                            .map(i -> new Point(Integer.parseInt(tokens.get(i)), Integer.parseInt(tokens.get(i + 1))))
                            .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_COORDINATE.message());
        }
    }

    private static List<String> validateTokens(List<String> pairs) {
        List<String> tokens = new ArrayList<>();
        pairs.forEach(pair -> {
            if (!pair.matches(validator)) {
                throw new IllegalArgumentException(ConsoleMessages.ERR_COORDINATE.message());
            }
            List<String> numbers = Arrays.asList(pair.split(braces));
            tokens.add(numbers.get(1).trim());
            tokens.add(numbers.get(2).trim());
        });
        return tokens;
    }
}