package coord.view;

import coord.model.figure.Point;
import coord.model.figure.Points;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    private static final String validator = "\\([ ]*[0-9]+[ ]*,[ ]*[0-9]+[ ]*\\)";
    private static final String delimiter = "\\(|,|\\)";

    public static Points parseCoordinates(String input) {
        return new Points(parse(tokenize(input)));
    }

    private static Stream<String> tokenize(String input) {
        return Stream.of(input.split("-"))
                .filter(token -> token.matches(validator));
    }

    private static List<Point> parse(Stream<String> tokens) {
        return tokens.map(pair -> parseEachToken(pair))
                .map(pair -> new Point(pair.get(0), pair.get(1)))
                .collect(Collectors.toList());
    }

    private static List<Integer> parseEachToken(String token) {
        String[] tokens = token.split(delimiter);
        return Arrays.asList(Integer.parseInt(tokens[1].trim()), Integer.parseInt(tokens[2].trim()));
    }
}