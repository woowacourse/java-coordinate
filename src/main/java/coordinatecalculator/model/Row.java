package coordinatecalculator.model;

import java.util.Arrays;
import java.util.List;

public class Row {
    List<String> row;

    public Row() {
        row = Arrays.asList("  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ");
    }

    public void setPosition(int index) {
        row.set(index, "x");
    }

    @Override
    public String toString() {
        return String.join("", row);
    }
}
