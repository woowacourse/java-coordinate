package calculator.domain;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Canvas implements Iterable<CanvasLine> {

    private static final int MAX_SIZE = (int) IntStream.rangeClosed(0, 24).count();
    private List<CanvasLine> canvas;

    public Canvas() {
        this.canvas = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            canvas.add(new CanvasLine());
        }
    }

    public Canvas(List<CanvasLine> canvas) {
        this.canvas = canvas;
    }

    public void plotCoordinate(Coordinate coordinate) {
        canvas.get(coordinate.getY()).plotX(coordinate.getX());
    }

    public Canvas plotCoordinate(AbstractFigure abstractFigure) {
        for (Coordinate coordinate : abstractFigure.getCoordinates()) {
            plotCoordinate(coordinate);
        }
        return new Canvas(canvas);
    }

    public boolean isPlottedCoordinate(Coordinate coordinate) {
        return canvas.get(coordinate.getY()).get(coordinate.getX());
    }

    public int size() {
        return canvas.size();
    }

    public CanvasLine getMapLine(int index) {
        return canvas.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canvas canvas1 = (Canvas) o;
        return Objects.equals(canvas, canvas1.canvas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(canvas);
    }

    @Override
    public Iterator<CanvasLine> iterator() {
        return canvas.iterator();
    }
}
