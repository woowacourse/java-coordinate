package calculator.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class UserInputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FORMAT_PATTERN = "^[(][-]?\\d+,[-]?\\d+[)]([-][(][-]?\\d+,[-]?\\d+[)])*$";
    private static final String POINT_PATTERN = "[-]?\\d+";
    private static final String EX_FORMAT_PATTERN_MESSAGE = "포맷에 맞게 입력해주세요";
    private static final String EX_COORDINATE_RANGE_MESSAGE = "좌표 범위는 0~24 사이입니다.";
    private static final int MAX_COORDINATE = 24;
    private static final int MIN_COORDINATE = 0;
    private static final String SINGLE_BLANK = " ";
    private static final String EMPTY = "";

    public List<Integer> generateCoordinates() {
        try {
            String inputText = UserInputView.inputByUser();
            UserInputView.checkFormat(inputText);
            return generateValidatedCoordinates(inputText);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return generateCoordinates();
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

    private static List<Integer> generateValidatedCoordinates(String inputText) {
        List<Integer> coordinates = new ArrayList<>();
        Pattern pointPattern = Pattern.compile(POINT_PATTERN);
        Matcher pointMatcher = pointPattern.matcher(inputText);

        while(pointMatcher.find()) {
            coordinates.add(checkRange(Integer.parseInt(pointMatcher.group(0)), EX_COORDINATE_RANGE_MESSAGE));
        }

        return coordinates;
    }

    private static int checkRange(int coordinate, String message) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException(message);
        }

        return coordinate;
    }

}
