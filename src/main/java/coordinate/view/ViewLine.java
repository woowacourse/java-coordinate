package coordinate.view;

import java.util.ArrayList;
import java.util.List;

public class ViewLine {
    private static final String CHECK = "x";
    private static final String DELIMITER = "";
    private static final String BLANK = "  ";

    private List<String> line;

    ViewLine() {
        line = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            line.add(BLANK);
        }
    }

    void checkPoint(int index) {
        line.set(index, CHECK);
    }

    @Override
    public String toString() {
        return String.join(DELIMITER, line);
    }
}
