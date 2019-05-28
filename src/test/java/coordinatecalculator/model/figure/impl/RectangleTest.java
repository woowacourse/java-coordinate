package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    void 사각형_넓이_구하기() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(20, 10);
        Coordinate c4 = new Coordinate(20, 20);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3, c4);
        assertThat(new Rectangle(coordinates).calculateArea()).isEqualTo(100);
    }

    @Test
    void 회전된_사각형인_경우() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(13, 6);
        Coordinate c3 = new Coordinate(17, 9);
        Coordinate c4 = new Coordinate(14, 13);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3, c4);
        assertDoesNotThrow(() -> new Rectangle(coordinates));
    }

    @Test
    void 마름모인_경우_예외_발생() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(15, 15);
        Coordinate c4 = new Coordinate(15, 5);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3, c4);
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(coordinates));
    }

    @Test
    void 평행사변형인_경우_예외_발생() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(15, 11);
        Coordinate c4 = new Coordinate(15, 21);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3, c4);
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(coordinates));
    }
}
