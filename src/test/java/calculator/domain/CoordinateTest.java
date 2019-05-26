package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author soojinroh
 * @version 1.0 2019-05-21
 */
public class CoordinateTest {

    Coordinate coordinate;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(10,15);
    }

    @Test
    void create_생성() {
        assertThat(coordinate).isEqualTo(new Coordinate(10,15));
    }

    @Test
    void matchAxis_좌표값_일치_확인() {
        boolean rightCoordinate = coordinate.matchAxis(10, 15);
        assertThat(rightCoordinate).isEqualTo(true);
    }

    @Test
    void matchAxis_좌표값_불일치_확인() {
        boolean rightCoordinate = coordinate.matchAxis(5, 15);
        assertThat(rightCoordinate).isEqualTo(false);
    }

    @Test
    void create_x값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Coordinate(-1, 10);
        });
    }

    @Test
    void create_y값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Coordinate(10, 25);
        });
    }
}
