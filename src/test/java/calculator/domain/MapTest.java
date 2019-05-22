package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class MapTest {

    Map map;
    Point point;

    @BeforeEach
    void setUp() {
        map = new Map();
        point = Point.create(10,2);
    }

    @Test
    void create_생성() {
        assertThat(map).isEqualTo(new Map());
    }

    @Test
    void create_사이즈_확인() {
        assertThat(map.size()).isEqualTo(24);
    }

    @Test
    void drawPoint_확인() {
        map.drawPoint(point);
        assertTrue(map.isPointDrawn(point));
    }
}
