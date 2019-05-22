package coordinate.util;

import coordinate.domain.Point;
import coordinate.domain.PointGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateRepresentation {
    private static final String ORDERED_PAIRS_SEPERATOR = "-";
    private static final Pattern orderedPairPattern = Pattern.compile("\\((.*),(.*)\\)");

    public static PointGroup convertCoordinatePair(String orderedPairs) {
        List<Point> coordinates = new ArrayList<>();
        Arrays.asList(orderedPairs.split(ORDERED_PAIRS_SEPERATOR))
                .forEach(x -> coordinates.add(convertCoordinate(x)));
        return new PointGroup(coordinates);
    }

    private static Point convertCoordinate(String orderedPair) {
        Matcher m = orderedPairPattern.matcher(orderedPair);
        if (m.find()) {
            return Point.create(Integer.parseInt(m.group(1).trim()), Integer.parseInt(m.group(2).trim()));
        }
        throw new IllegalArgumentException("좌표는 (x,y) 또는 (x1,y1)-(x2,y2) 꼴로 입력하세요.");
    }
}
