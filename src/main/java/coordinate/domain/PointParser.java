package coordinate.domain;

import coordinate.view.CoordinateNumberSplitter;

import java.util.List;

public class PointParser {
    public static Points parse(String input, PointsFactory factory) {
        List<Integer> numbers = inputToCoordinateNumbers(input);

        return factory.createFromNumbers(numbers);
    }

    private static List<Integer> inputToCoordinateNumbers(String input) {
        return CoordinateNumberSplitter.split(input);
    }
}
