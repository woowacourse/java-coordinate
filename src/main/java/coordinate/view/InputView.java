package coordinate.view;

import coordinate.domain.Point;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String DELIMITER = "-";

    public static List<String> inputCoordinate() {
        String consoleInput = new Scanner(System.in).nextLine();
        return Arrays.asList(consoleInput.split(DELIMITER));
    }
}
