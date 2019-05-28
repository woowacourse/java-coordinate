package coordinate.view;

import coordinate.domain.Point;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern PATTERN = Pattern.compile("[(]([\\d]*)[,]([\\d]*)[)]");
    private static final String DELIMITER = "-";

    public static String inputCoordinate() {
        return new Scanner(System.in).nextLine();
    }
}
