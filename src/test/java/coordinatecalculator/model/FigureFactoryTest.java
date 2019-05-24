package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureFactoryTest {
    @Test
    public void line() {
        List<Coordinate> points = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(2, 3));

        PlaneFigure figure = FigureFactory.createFigure(points);
        assertThat(figure).isInstanceOfAny(Line.class);
    }

    @Test
    public void triangle() {
        List<Coordinate> points = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(5, 2),
                new Coordinate(2, 3));

        PlaneFigure figure = FigureFactory.createFigure(points);
        assertThat(figure).isInstanceOfAny(Triangle.class);
    }

    @Test
    public void rectrangle() {
        List<Coordinate> points = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(2, 2),
                new Coordinate(2, 1),
                new Coordinate(1, 1));

        PlaneFigure figure = FigureFactory.createFigure(points);
        assertThat(figure).isInstanceOfAny(Rectangle.class);
    }

}
