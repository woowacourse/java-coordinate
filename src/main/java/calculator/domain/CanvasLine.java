package calculator.domain;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class CanvasLine implements Iterable<Boolean> {

    private static final int MAX_SIZE = (int) IntStream.rangeClosed(0, 24).count();
    private List<Boolean> canvasLine;

    public CanvasLine() {
        this.canvasLine = new ArrayList<>(Collections.nCopies(MAX_SIZE, false));
    }

    public boolean get(int index) {
        return canvasLine.get(index);
    }

    public int size() {
        return canvasLine.size();
    }

    public void plotX(int xCoordinate) {
        canvasLine.set(xCoordinate, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CanvasLine line1 = (CanvasLine) o;
        return Objects.equals(canvasLine, line1.canvasLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(canvasLine);
    }

    @Override
    public Iterator<Boolean> iterator() {
        return canvasLine.iterator();
    }
}
