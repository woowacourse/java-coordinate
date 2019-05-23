package coordinate.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueGenerator {
    public static List<String> splitCoordinates(String coordinates) {
        return Arrays.asList(removeBrackets(coordinates).split("-"));
    }

    private static String removeBrackets(String coordinate) {
        return coordinate.replaceAll("\\(|\\)","");
    }

    public static List<String> splitValue(List<String> temp) {
        List<String> returnList = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            List<String> temptemp = Arrays.asList(temp.get(i).split(","));
            for (int j = 0; j <temptemp.size(); j++) {
                returnList.add(temptemp.get(j));
            }
        }

        return returnList;
    }
}
