package coordinate.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoordinateNumberSplitter {
    private static final String EMPTY = "";
    private static final String START_POINT = "(";
    private static final String END_POINT = ")";
    private static final String NUMBER_SEPARATOR = ",";
    private static final String POINT_SEPARATOR = "-";


    public static List<Integer> split(String input) {
        input = input.replace(POINT_SEPARATOR, NUMBER_SEPARATOR);
        input = input.replace(START_POINT, EMPTY);
        input = input.replace(END_POINT, EMPTY);

        return Arrays.asList(input.split(NUMBER_SEPARATOR))
                .stream()
                .mapToInt(str -> Integer.parseInt(str))
                .boxed().collect(Collectors.toList());
    }
}
