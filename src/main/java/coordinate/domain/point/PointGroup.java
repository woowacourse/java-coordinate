package coordinate.domain.point;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class PointGroup {
    private final List<Point> pointGroup;

    public PointGroup(Matcher matcher) {
        this.pointGroup = generate(matcher);
    }

    private List<Point> generate(Matcher matcher) {
        List<Point> pointGroup = new ArrayList<>();
        while (matcher.find()) {
            String value = matcher.group();
            pointGroup.add(Point.of(value));
        }
        return pointGroup;
    }

    public List<Point> getPointGroup() {
        return pointGroup;
    }
}
