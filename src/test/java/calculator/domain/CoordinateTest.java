package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-29
 */
public class CoordinateTest {
    Coordinate coordinate;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(5);
    }

    @Test
    void create_확인() {
        assertThat(coordinate).isEqualTo(new Coordinate(5));
    }

    @Test
    void create_경계값_확인_마이너스1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-1);
        });
    }

    @Test
    void create_경계값_확인_25() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25);
        });
    }
}
