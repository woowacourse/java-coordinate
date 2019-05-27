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
    void create_예외_0개() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FigureFactory().create(new Coordinates());
        });
    }
}