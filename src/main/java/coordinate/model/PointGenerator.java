package coordinate.model;

import java.util.List;

public class PointGenerator {
    private static final String INPUT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)((-)\\(([0-9]+)(,)([0-9]+)\\))*";
    private List<Point> points;

    public PointGenerator(String text) {
        checkValidForm(text);
    }

    private void checkValidForm(String text) {
        if (!text.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException("입력 형식 오류");
        }
    }
}
