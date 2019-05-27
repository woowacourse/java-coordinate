package coordinatecalculator.model;

import java.util.*;

public class StringSplitter {
    public static List<String> split(String points) {
        List<String> cleanedPoints = removeUnnecessaryCharacters(points);
        Collections.sort(cleanedPoints);
        validatePoints(cleanedPoints);
        List<String> values = splitPoints(cleanedPoints);
        return values;
    }

    private static void validatePoints(List<String> values) {
        Set<String> valuesForValidating = new HashSet<>(values);
        if (valuesForValidating.size() != values.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> removeUnnecessaryCharacters(String points) {
        points = points.replaceAll("\\(|\\)","");
        return new ArrayList<>(Arrays.asList(points.split("-")));
    }

    private static List<String> splitPoints(List<String> cleanedPoints) {
        List<String> values = new ArrayList<>();
        for (int i = 0, n = cleanedPoints.size(); i < n; i++) {
            List<String> currentValues = new ArrayList<>(Arrays.asList(cleanedPoints.get(i).split(",")));
            splitValues(values, currentValues);
        }
        return values;
    }

    private static void splitValues(List<String> values, List<String> currentValues) {
        for (int i = 0, n = currentValues.size(); i < n; i++) {
            values.add(currentValues.get(i));
        }
    }
}
