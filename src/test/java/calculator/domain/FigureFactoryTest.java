package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0 2019-05-27
 */
class FigureFactoryTest {
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        coordinates = new Coordinates();
        coordinates.add(new Coordinate(0,0));
        coordinates.add(new Coordinate(1,0));
        coordinates.add(new Coordinate(1,10));
    }

    @Test
    void create_예외_1개() {
        Coordinates exCoordinates = new Coordinates();
        exCoordinates.add(new Coordinate(1,1));
        assertThrows(IllegalArgumentException.class, () -> {
            new FigureFactory().create(exCoordinates);
        });
    }

    @Test
    void create_4각형_초과_예외_확인() {
        coordinates.add(new Coordinate(20,10));
        coordinates.add(new Coordinate(2,1));
        assertThrows(Exception.class, () -> {
            new FigureFactory().create(coordinates);
        });
    }
}