package coordinate.view;

import coordinate.MessageConstants.MessageConstant;
import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public Points inputCoordinates() {
        System.out.println(MessageConstant.INPUT_COORDINATES);
        String input = SCAN.nextLine();

        try {
            return getPoints(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private Points getPoints(String input) {
        List<Integer> numbers = extractCoordinates(input);
        Points points = Points.create();

        for (int i = 0; i < numbers.size(); i += 2) {
            points.addPoint(Point.create(numbers.get(i), numbers.get(i + 1)));
        }

        return points;
    }

    private List<Integer> extractCoordinates(String input) {
        String result = input.replace(MessageConstant.DASH, MessageConstant.SPLIT_COMMA)
                .replace(MessageConstant.START_POINT, MessageConstant.EMPTY)
                .replace(MessageConstant.END_POINT, MessageConstant.EMPTY);

        return Arrays.stream(result.split(MessageConstant.SPLIT_COMMA))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
