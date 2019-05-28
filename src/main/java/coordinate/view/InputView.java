package coordinate.view;

import coordinate.domain.Point;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern PATTERN = Pattern.compile("[(]([\\d]*)[,]([\\d]*)[)]");
    private static final String DELIMITER = "-";

    public static List<Point> inputCoordinate() {
        List<Point> points;
        String consoleInput = new Scanner(System.in).nextLine();
        List<String> inputs = Arrays.asList(consoleInput.split(DELIMITER));
        try {
            validateDuplication(inputs);
            points = getPoints(inputs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinate();
        }

        return points;
    }

    private static List<Point> getPoints(List<String> inputs) {
        List<Point> points = new ArrayList<>();
        for (String input : inputs) {
            Matcher m = PATTERN.matcher(input);
            m.matches();
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            points.add(new Point(x, y));
        }
        return points;
    }

    private static void validateDuplication(List<String> inputs) {
        Set<String> set = new HashSet<>(inputs);
        if (set.size() != inputs.size()) {
            throw new IllegalArgumentException("중복된 점이 입력되었습니다.");
        }
    }
}
