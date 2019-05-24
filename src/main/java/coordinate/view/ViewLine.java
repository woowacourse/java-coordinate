package coordinate.view;

import java.util.Arrays;
import java.util.List;

public class ViewLine {
    private static final String CHECK = "x";
    private static final String DELIMITER = "";

    private List<String> line;

    ViewLine() {
        line = Arrays.asList("  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ");
    }

    void setPosition(int index) {
        line.set(index, CHECK);
    }

    @Override
    public String toString() {
        return String.join(DELIMITER, line);
    }
}
