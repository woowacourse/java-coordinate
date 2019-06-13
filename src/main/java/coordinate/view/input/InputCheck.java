package coordinate.view.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCheck {
    public static Matcher matchPoint(String point) {
        Matcher matcher = Pattern.compile("(\\d{1,2},\\d{1,2})").matcher(point);
        return matcher;
    }
}
