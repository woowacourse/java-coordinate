package coord.view;

import coord.model.Point;
import coord.model.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Parser {
    private static final String validator = "\\([ ]*[0-9]+[ ]*,[ ]*[0-9]+[ ]*\\)";
    private static final String delimiter = "\\(|,|\\)";

    public static Points parseCoordinates(String input) {
        List<Integer> tokens = validateTokens(input);
        return new Points(
                IntStream.iterate(0, i -> i + 2)
                        .limit(tokens.size() / 2).boxed()
                        .map(i -> new Point(tokens.get(i), tokens.get(i + 1)))
                        .collect(Collectors.toList())
        );
    }

    private static List<Integer> validateTokens(String input) {
        List<Integer> tokens = new ArrayList<>();
        Arrays.asList(input.split("-")).forEach(pair -> {
            if (!pair.matches(validator)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
            }
            tokens.addAll(
                    Stream.of(pair.split(delimiter))
                            .filter(x -> x.length() != 0)
                            .map(x -> Integer.parseInt(x.trim()))
                            .collect(Collectors.toList())
            );
        });
        return tokens;
    }
}