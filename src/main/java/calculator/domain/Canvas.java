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

    public void plotCoordinate(Point point) {
        canvas.get(point.getY()).plotX(point.getX());
    }

    public Canvas plotCoordinate(AbstractFigure abstractFigure) {
        for (Point point : abstractFigure.getCoordinates()) {
            plotCoordinate(point);
        }
        return new Canvas(canvas);
    }

    public boolean isPlottedCoordinate(Point point) {
        return canvas.get(point.getY()).get(point.getX());
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
