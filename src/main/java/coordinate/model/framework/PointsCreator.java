package coordinate.model.framework;

import coordinate.model.Point;
import coordinate.model.Points;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointsCreator {
        private static final String POINT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)";

                public static Points create(List<String> inputs){
                        List<Point> points = new ArrayList<>();
                        for (String input : inputs) {
                                Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
                                matcher.matches();
                                int x = Integer.parseInt(matcher.group(1));
                                int y = Integer.parseInt(matcher.group(3));
                                points.add(new Point(x, y));
                        }
                return new Points(points);
        }
}
