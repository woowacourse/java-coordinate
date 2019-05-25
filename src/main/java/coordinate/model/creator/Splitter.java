package coordinate.model.creator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public static List<String> splitValue(String coordinate) {
        String[] temps = splitCoordinates(coordinate);
        List<String> returnList = new ArrayList<>();

        for (String temp : temps) {
            returnList.addAll(Arrays.asList(temp.split(",")));
        }

        return returnList;
    }

    private static String[] splitCoordinates(String coordinates) {
        return removeBrackets(coordinates).split("-");
    }

    private static String removeBrackets(String coordinate) {
        return coordinate.replaceAll("\\(|\\)", "");
    }
}
