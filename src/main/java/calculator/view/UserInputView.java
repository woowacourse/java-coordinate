package calculator.view;

import calculator.domain.*;

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
    private static final String COORDINATE_PATTERN = "[-]?\\d+,[-]?\\d+";
    private static final String EX_FORMAT_PATTERN_MESSAGE = "포맷에 맞게 입력해주세요";
    private static final String INPUT_MESSAGE = "좌표를 입력하세요.";
    private static final String SINGLE_BLANK = " ";
    private static final String EMPTY = "";
    private static final String COMMA = ",";

    public static AbstractFigure generaValidatedFigure() {
        try {
            System.out.println(INPUT_MESSAGE);
            String inputText = inputByUser();
            checkFormat(inputText);
            return generateFigure(inputText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return generaValidatedFigure();
        }
    }

    private static String inputByUser() {
        return SCANNER.nextLine().replaceAll(SINGLE_BLANK, EMPTY);
    }

    private static void checkFormat(String inputText) {
        Pattern formatPattern = Pattern.compile(FORMAT_PATTERN);
        Matcher formatMatcher = formatPattern.matcher(inputText);

        checkElementFormat(formatMatcher);

        while (formatMatcher.find()) {
            formatMatcher.group(0);
        }
    }

    private static void checkElementFormat(Matcher formatMatcher) {
        if (!formatMatcher.find()) {
            throw new IllegalArgumentException(EX_FORMAT_PATTERN_MESSAGE);
        }
    }

    private static AbstractFigure generateFigure(String inputText) {
        Points points = generatePoints(inputText);
        AbstractFigure abstractFigure = new FigureFactory().create(FigureType.valueOf(points));
        return abstractFigure;
    }

    private static Points generatePoints(String inputText) {
        Points points = new Points();
        Pattern pointPattern = Pattern.compile(COORDINATE_PATTERN);
        Matcher pointMatcher = pointPattern.matcher(inputText);

        while (pointMatcher.find()) {
            int xCoordinate = Integer.parseInt(pointMatcher.group(0).split(COMMA)[0]);
            int yCoordinate = Integer.parseInt(pointMatcher.group(0).split(COMMA)[1]);
            points.add(new Point(xCoordinate, yCoordinate));
        }
        return points;
    }

}
