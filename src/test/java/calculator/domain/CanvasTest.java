package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class CanvasTest {

    Canvas canvas;
    Coordinate coordinate;
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        canvas = new Canvas();
        coordinate = new Coordinate(10,2);
        coordinates = new Coordinates();
    }

    @Test
    void create_생성() {
        assertThat(canvas).isEqualTo(new Canvas());
    }

    @Test
    void create_사이즈_확인() {
        assertThat(canvas.size()).isEqualTo(25);
    }

    @Test
    void plotCoordinate_확인() {
        coordinates.add((coordinate));
        canvas.plotCoordinate(coordinate);
        assertTrue(canvas.isPlottedCoordinate(coordinate));
    }

    @Test
    void plotCoordinate_figure_확인() {
        coordinates.add(coordinate);
        coordinates.add(new Coordinate(21,5));
        canvas.plotCoordinate(new FigureFactory().create(coordinates));
        assertTrue(canvas.isPlottedCoordinate(coordinate) && canvas.isPlottedCoordinate(new Coordinate(21,5)));
    }
}
