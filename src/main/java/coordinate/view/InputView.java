package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public Points inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        String input = SCAN.nextLine();

        try {
            return getPoints(input);
        } catch (IllegalArgumentException e) {
            e.getMessage();
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
        String result = input.replace("-", ",")
                .replace(")", "").replace("(", "");

        return Arrays.stream(result.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
