package coordinatecalculator.util;

import coordinatecalculator.domain.Coordinate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {
    private static final String COORDINATE_PATTERN = "[(]([0-9]+),([0-9]+)[)]";
    private static final String HYPHEN = "-";
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";
    private static final int MAX_LENGTH = 7;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Coordinate> getCoordinates() {
        System.out.println("좌표를 입력하세요.");
        String inputCoordinates = SCANNER.nextLine();
        List<String> coordinates = Arrays.asList(inputCoordinates.split(HYPHEN));

        return makeCoordinates(coordinates);
    }

    private static List<Coordinate> makeCoordinates(List<String> inputCoordinates) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (String coordinate : inputCoordinates) {
            Matcher matcher = Pattern.compile(COORDINATE_PATTERN).matcher(coordinate);
            checkValidPattern(matcher, coordinate);
            coordinates.add(new Coordinate(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2))));
        }
        Collections.sort(coordinates);
        return coordinates;
    }

    private static void checkValidPattern(final Matcher matcher, final String coordinate) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("올바르지 않는 입력입니다!!");
        }
        if (coordinate.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("(-)올바르게 넣어주세요!!");
        }
        if (!(coordinate.startsWith(OPEN_PARENTHESIS) && coordinate.endsWith(CLOSE_PARENTHESIS))) {
            throw new IllegalArgumentException("괄호를 올바르게 쳐주세요!");
        }
    }
}
