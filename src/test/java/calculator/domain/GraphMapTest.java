package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class GraphMapTest {

    GraphMap graphMap;
    Coordinate coordinate;
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        graphMap = new GraphMap();
        coordinate = new Coordinate(10,2);
        coordinates = new Coordinates();
    }

    @Test
    void create_생성() {
        assertThat(graphMap).isEqualTo(new GraphMap());
    }

    @Test
    void create_사이즈_확인() {
        assertThat(graphMap.size()).isEqualTo(25);
    }

    @Test
    void drawPoint_확인() {
        coordinates.add((coordinate));
        graphMap.drawCoordinate(coordinate);
        assertTrue(graphMap.isCoordinateDrawn(coordinate));
    }
}
