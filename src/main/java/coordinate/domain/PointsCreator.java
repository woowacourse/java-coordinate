package coordinate.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointsCreator {
    private static final Pattern POINT_PATTERN = Pattern.compile("[(]([\\d]*)[,]([\\d]*)[)]");

    public static List<Point> create(List<String> inputs) {
        validateDuplication(inputs);

        List<Point> points = new ArrayList<>();
        for (String input : inputs) {
            Matcher matcher = POINT_PATTERN.matcher(input);
            matcher.matches();
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
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
