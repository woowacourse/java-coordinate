package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<Double> lengths() {
        return lines.stream().mapToDouble(Line::length).boxed().collect(Collectors.toList());
    }
}
