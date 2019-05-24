package coordinatecalculator.model.figure;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figurecreator.FigureCreator;
import coordinatecalculator.model.figurecreator.impl.LineCreator;
import coordinatecalculator.model.figurecreator.impl.RectangleCreator;
import coordinatecalculator.model.figurecreator.impl.TriangleCreator;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FigureFactory {
    private static final int LINE_COORDINATES = 2;
    private static final int TRIANGLE_COORDINATES = 3;
    private static final int RECTANGLE_COORDINATES = 4;

    private static final Map<Integer, FigureCreator> FIGURE_CREATOR_FINDER =
            Stream.of(
                    new AbstractMap.SimpleImmutableEntry<>(LINE_COORDINATES, new LineCreator()),
                    new AbstractMap.SimpleImmutableEntry<>(TRIANGLE_COORDINATES, new TriangleCreator()),
                    new AbstractMap.SimpleImmutableEntry<>(RECTANGLE_COORDINATES, new RectangleCreator())
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static PlaneFigure createFigure(List<Coordinate> coordinates) {
        checkIsInMap(coordinates);
        return FIGURE_CREATOR_FINDER.get(coordinates.size()).create(coordinates);
    }

    private static void checkIsInMap(List<Coordinate> coordinates) {
        if (!FIGURE_CREATOR_FINDER.containsKey(coordinates.size())) {
            throw new IllegalArgumentException("잘못된 좌표값 개수입니다.");
        }
    }
}
