package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class CoordinatesTest {
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        coordinates = new Coordinates();
        coordinates.add(new Coordinate(10,20));
        coordinates.add(new Coordinate(10,10));
    }

    @Test
    void create_생성() {
        assertThat(coordinates.size()).isEqualTo(2);
    }

    @Test
    void add_중복_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinates.add(new Coordinate(10,10));
        });
    }

    @Test
    void add_추가_갯수_확인() {
        coordinates.add(new Coordinate(0,10));
        coordinates.add(new Coordinate(0,20));

        assertThrows(IllegalArgumentException.class, () -> {
            coordinates.add(new Coordinate(1,1));
        });
    }

    @Test
    void checkTriangle_일직선_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinates.add(new Coordinate(10,5));
        });
    }

    @Test
    void checkRectangle_직사각형_확인() {
        coordinates.add(new Coordinate(0,10));
        coordinates.add(new Coordinate(0,20));
    }

    @Test
    void checkRectangle_직사각형_예외() {
        Coordinates coordinatesException = new Coordinates();
        coordinatesException.add(new Coordinate(10,20));
        coordinatesException.add(new Coordinate(10,10));
        coordinatesException.add(new Coordinate(0,10));
        assertThrows(IllegalArgumentException.class, () -> {
            coordinatesException.add(new Coordinate(0,5));
        });

    }
}
