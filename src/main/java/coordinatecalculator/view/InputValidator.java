package coordinatecalculator.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern POINT_PATTERN = Pattern.compile("\\(([0-9]*),([0-9]*)\\)");
    private static final Pattern COORDINATE_PATTERN = Pattern.compile("[0-9]*");

    public static boolean isValidCoordinate(String scannedCoordinate){
        return COORDINATE_PATTERN.matcher(scannedCoordinate).find();
    }

    public static boolean isValidPoint(String scannedPoint){
        return POINT_PATTERN.matcher(scannedPoint).find();
    }

    public static String findPointX(String scannedPoint){
        Matcher matcher=POINT_PATTERN.matcher(scannedPoint);
        matcher.find();
        return matcher.group(1);
    }

    public static String findPointY(String scannedPoint){
        Matcher matcher=POINT_PATTERN.matcher(scannedPoint);
        matcher.find();
        return matcher.group(2);
    }

}
