package coordinatecalculator.model.figure;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.impl.Line;
import coordinatecalculator.model.figure.impl.Rectangle;
import coordinatecalculator.model.figure.impl.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FigureCreatorsTest {
    @Test
    void line() {
        List<Coordinate> points = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(2, 3));

        PlaneFigure figure = FigureCreators.findFigureCreator(points.size()).create(points);
        assertThat(figure).isInstanceOfAny(Line.class);
    }

    @Test
    void triangle() {
        List<Coordinate> points = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(5, 2),
                new Coordinate(2, 3));

        PlaneFigure figure = FigureCreators.findFigureCreator(points.size()).create(points);
        assertThat(figure).isInstanceOfAny(Triangle.class);
    }

    @Test
    void rectrangle() {
        List<Coordinate> points = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(2, 2),
                new Coordinate(2, 1),
                new Coordinate(1, 1));

        PlaneFigure figure = FigureCreators.findFigureCreator(points.size()).create(points);
        assertThat(figure).isInstanceOfAny(Rectangle.class);
    }

}
