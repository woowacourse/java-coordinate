package coordinatecalculator.util;

import coordinatecalculator.domain.Coordinate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Coordinate> getCoordinates() {
        System.out.println("좌표를 입력하세요.");
        String inputCoordinates = SCANNER.nextLine();
        List<String> coordinates = Arrays.asList(inputCoordinates.split("-"));

        return makeCoordinates(coordinates);
    }

    private static List<Coordinate> makeCoordinates(List<String> inputCoordinates) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (String coordinate : inputCoordinates) {
            Matcher matcher = Pattern.compile("[(]([0-9]+),([0-9]+)[)]").matcher(coordinate);
            checkValidPattern(matcher);
            coordinates.add(new Coordinate(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2))));
        }
        return coordinates;
    }

    private static void checkValidPattern(Matcher matcher) {
        //TODO 나중에 예외처리 더 추가
        if (!matcher.find()) {
            throw new IllegalArgumentException("올바르지 않는 입력입니다!!");
        }
    }

}
