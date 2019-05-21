package coord;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String delimiter = "\\(|,|\\)-\\(|\\)";

    public static List<Point> parseCoordinates(String input) {
        List<String> tokens = Arrays.asList(input.split(delimiter));
        return IntStream.iterate(1, i -> i + 2).limit(tokens.size() / 2).boxed().map(i -> new Point(Integer.parseInt(tokens.get(i).trim()), Integer.parseInt(tokens.get(i + 1).trim()))).collect(Collectors.toList());
    }
}