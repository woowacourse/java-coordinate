package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class FigureFactory {
    private static final Map<FigureType, Function<Coordinates, AbstractFigure>> figureCreate;

    static {
        figureCreate = new HashMap<>();
        figureCreate.put(FigureType.LINE, Line::new);
        figureCreate.put(FigureType.TRIANGLE, Triangle::new);
        figureCreate.put(FigureType.RECTANGLE, Rectangle::new);
    }

    public AbstractFigure create(Coordinates coordinates) {
        return figureCreate.get(FigureType.valueOf(coordinates.size())).apply(coordinates);
    }
}
