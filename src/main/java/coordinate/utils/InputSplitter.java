package coordinate.utils;

import java.util.Arrays;
import java.util.List;

public class InputSplitter {

    public static List<String> getSplit(String input, String splitter) {
        return Arrays.asList(input.split(splitter));
    }
}
