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
        coordinates.add(Coordinate.create(10,20));
        coordinates.add(Coordinate.create(10,10));
    }

    @Test
    void create_생성() {
        assertThat(coordinates.size()).isEqualTo(2);
    }

    @Test
    void add_중복_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinates.add(Coordinate.create(10,10));
        });
    }

    @Test
    void add_추가_갯수_확인() {
        coordinates.add(Coordinate.create(3,17));
        coordinates.add(Coordinate.create(9,21));

        assertThrows(IllegalArgumentException.class, () -> {
            coordinates.add(Coordinate.create(1,1));
        });
    }

    @Test
    void checkTriangle_일직선_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            coordinates.add(Coordinate.create(10,5));
        });
    }
}
