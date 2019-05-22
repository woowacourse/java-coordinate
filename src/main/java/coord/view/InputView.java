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
    private static final String validator = "\\([ ]*[0-9]+[ ]*,[ ]*[0-9]+[ ]*\\)";
    private static final String delimiter = "\\(|,|\\)";

    public static Points inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        try {
            return parseCoordinates(input.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static Points parseCoordinates(String input) {
        List<String> tokens = validateTokens(Arrays.asList(input.split("-")));
        System.out.println(tokens);
        try {
            return new Points(
                IntStream.iterate(0, i -> i + 2)
                .limit(tokens.size() / 2).boxed()
                .map(i -> new Point(Integer.parseInt(tokens.get(i)), Integer.parseInt(tokens.get(i + 1))))
                .collect(Collectors.toList())
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }

    private static List<String> validateTokens(List<String> pairs) {
        List<String> tokens = new ArrayList<>();
        pairs.forEach(pair -> {
            if (!pair.matches(validator)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
            }
            List<String> numbers = Arrays.asList(pair.split(delimiter));
            tokens.add(numbers.get(1).trim());
            tokens.add(numbers.get(2).trim());
        });
        return tokens;
    }
}