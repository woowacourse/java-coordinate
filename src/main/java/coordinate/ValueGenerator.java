package coordinate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueGenerator {
    public static List<String> splitCoordinates(String coordinates) {
        return Arrays.asList(coordinates.split("-"));
    }

    public static String removeBrackets(String coordinate) {
        return coordinate.replaceAll("\\(|\\)","");
    }

    public static List<String> splitValue(String values) {
        return Arrays.asList(values.split(","));
    }
}
