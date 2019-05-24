package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.coordinate.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinesTest {

    @Test
    void 한_직선_위에_세_좌표가_있는_경우_예외_발생() {
        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(10, 10);
        Coordinate c3 = new Coordinate(15, 15);
        Coordinate c4 = new Coordinate(10, 20);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3, c4);

        assertThrows(IllegalArgumentException.class, () -> new Lines(new Coordinates(coordinates)));
    }

    @Test
    void 한_직선_위에_세_좌표가_있지_않은_경우() {
        Coordinate c1 = new Coordinate(5, 5);
        Coordinate c2 = new Coordinate(10, 10);
        Coordinate c3 = new Coordinate(15, 16);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);

        assertDoesNotThrow(() -> new Lines(new Coordinates(coordinates)));
    }
}
