package coordinate.domain;

import java.util.List;

public class Lines {

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int getLinesLength() {
        return this.lines.size();
    }

    public boolean isNotEqual(int index) {
        return !lines.get(index).equals(lines.get(index + 1));
    }

    public List<Line> getLines() {
        return lines;
    }
}
