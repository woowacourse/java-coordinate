package coordinate.view;

import java.util.Arrays;
import java.util.List;

public class ViewLine {
    private List<String> line;

    ViewLine() {
        line = Arrays.asList("  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ");
    }

    void setPosition(int index) {
        line.set(index, "x");
    }

    @Override
    public String toString() {
        return String.join("", line);
    }
}
