package coordinate.view;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> split(String text) {
        return Arrays.asList(text.split("-"));
    }
}
