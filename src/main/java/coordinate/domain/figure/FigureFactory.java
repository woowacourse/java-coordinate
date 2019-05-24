package coordinate.domain.figure;

import coordinate.domain.nonefigure.PointGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static Map<Integer, Function<PointGroup, Figure>> figures;

    static {
        figures = new HashMap<>();
        figures.put(2, (pointGroup) -> new Line(pointGroup));
        figures.put(3, (pointGroup) -> new Triangle(pointGroup));
        figures.put(4, (pointGroup) -> new Rectangle(pointGroup));
    }
    public static Figure getInstance(PointGroup pointGroup) {
        return figures.get(pointGroup.size()).apply(pointGroup);
    }

}
