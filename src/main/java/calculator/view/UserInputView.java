package calculator.view;

import calculator.domain.figure.Coordinate;
import calculator.domain.figure.Coordinates;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author soojinroh
 * @version 1.0 2019-05-21
 */
public class UserInputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FORMAT_PATTERN = "^[(][-]?\\d+,[-]?\\d+[)]([-][(][-]?\\d+,[-]?\\d+[)])*$";
    private static final String COORDINATE_PATTERN = "[-]?\\d+,[-]?\\d+";
    private static final String EX_FORMAT_PATTERN_MESSAGE = "포맷에 맞게 입력해주세요";
    private static final String INPUT_MESSAGE = "좌표를 입력하세요.";
    private static final String SINGLE_BLANK = " ";
    private static final String EMPTY = "";
    private static final String COMMA = ",";

    public static Coordinates generaValidatedCoordinates() {
        try {
            System.out.println(INPUT_MESSAGE);
            String inputText = UserInputView.inputByUser();
            UserInputView.checkFormat(inputText);
            return generateCoordinates(inputText);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return generaValidatedCoordinates();
        }
    }

    private static String inputByUser() {
        return SCANNER.nextLine().replaceAll(SINGLE_BLANK, EMPTY);
    }

    private static String checkFormat(String inputText) {
        Pattern formatPattern = Pattern.compile(FORMAT_PATTERN);
        Matcher formatMatcher = formatPattern.matcher(inputText);

        checkElementFormat(formatMatcher);

        while(formatMatcher.find()) {
            inputText = formatMatcher.group(0);
        }

        return inputText;
    }

    private static void checkElementFormat(Matcher formatMatcher) {
        if (!formatMatcher.find()) {
            throw new IllegalArgumentException(EX_FORMAT_PATTERN_MESSAGE);
        }
    }

    private static Coordinates generateCoordinates(String inputText) {
        Coordinates coordinates = new Coordinates();
        Pattern coordinatePattern = Pattern.compile(COORDINATE_PATTERN);
        Matcher coordinateMatcher = coordinatePattern.matcher(inputText);

        while(coordinateMatcher.find()) {
            int xCoordinate = Integer.parseInt(coordinateMatcher.group(0).split(COMMA)[0]);
            int yCoordinate = Integer.parseInt(coordinateMatcher.group(0).split(COMMA)[1]);
            coordinates.add(new Coordinate(xCoordinate, yCoordinate));
        }
        return coordinates;
    }

}
