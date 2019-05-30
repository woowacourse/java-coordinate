package coordinate.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> split(String text) {
        return Arrays.asList(text.split("-"));
    }

    public static List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String text : split(input)) {
            text = text.replace("(", "").replace(")", "");
            Arrays.stream(text.split(",")).forEach(n -> numbers.add(Integer.parseInt(n)));
        }
        return numbers;
    }
}
