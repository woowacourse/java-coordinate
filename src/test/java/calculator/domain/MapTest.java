package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author soojinroh
 * @version 1.0 2019-05-22
 */
public class MapTest {

    Map map;
    Coordinate coordinate;
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(10,2);
        coordinates = new Coordinates();
        coordinates.add((coordinate));
        map = new Map(coordinates);
    }

    @Test
    void create_생성() {
        assertThat(map).isEqualTo(new Map(coordinates));
    }

    @Test
    void create_사이즈_확인() {
        assertThat(map.size()).isEqualTo(25);
    }

    @Test
    void drawPoint_확인() {
        assertTrue(map.isCoordinateDrawn(coordinate));
    }
}
