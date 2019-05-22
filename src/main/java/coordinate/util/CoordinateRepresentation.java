package coordinate.util;

import coordinate.domain.Coordinate.Coordinates;
import coordinate.domain.Coordinate.CoordinatesGroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateRepresentation {
    private static final String ORDERED_PAIRS_SEPERATOR = "-";
    private static final Pattern orderedPairPattern = Pattern.compile("\\((.*),(.*)\\)");

    public static CoordinatesGroup convertCoordinatePair(String orderedPairs) {
        Set<Coordinates> coordinates = new HashSet<>();
        Arrays.asList(orderedPairs.split(ORDERED_PAIRS_SEPERATOR))
                .forEach(x -> coordinates.add(convertCoordinate(x)));
        return new CoordinatesGroup(coordinates);
    }

    private static Coordinates convertCoordinate(String orderedPair) {
        Matcher m = orderedPairPattern.matcher(orderedPair);
        if (m.find()) {
            return Coordinates.create(Integer.parseInt(m.group(1).trim()), Integer.parseInt(m.group(2).trim()));
        }
        throw new IllegalArgumentException("좌표는 (x,y) 또는 (x1,y1)-(x2,y2) 꼴로 입력하세요.");
    }
}
