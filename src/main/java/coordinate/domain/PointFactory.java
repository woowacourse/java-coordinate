package coordinate.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointFactory {
    private static final Pattern PATTERN = Pattern.compile("[(]([\\d]*)[,]([\\d]*)[)]");
    private static final String DELIMITER = "-";

    public static List<Point> create(String consoleInput) {
        List<String> inputs = Arrays.asList(consoleInput.split(DELIMITER));
        validateDuplication(inputs);
        return getPoints(inputs);
    }

    private static void validateDuplication(List<String> inputs) {
        Set<String> set = new HashSet<>(inputs);
        if (set.size() != inputs.size()) {
            throw new IllegalArgumentException("중복된 점이 입력되었습니다.");
        }
    }

    private static List<Point> getPoints(List<String> inputs) {
        List<Point> points = new ArrayList<>();
        for (String input : inputs) {
            getPoint(points, input);
        }
        return points;
    }

    private static void getPoint(List<Point> points, String input) {
        try {
            Matcher m = PATTERN.matcher(input);
            m.matches();
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            points.add(new Point(x, y));
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("좌표를 제대로 입력해 주세요");
        }
    }

}
