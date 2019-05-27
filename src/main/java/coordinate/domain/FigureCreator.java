package coordinate.domain;

import java.util.List;
import java.util.function.Function;

public class FigureCreator {
    private Function<List<Point>, Figure> creator;

    public FigureCreator(Function<List<Point>, Figure> creator) {
        this.creator = creator;
    }

    Figure createFigureBy(List<Point> points) {
        return creator.apply(points);
    }
}