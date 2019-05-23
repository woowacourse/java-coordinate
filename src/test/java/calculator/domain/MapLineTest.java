package calculator.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author soojinroh
 * @version 1.0 2019-05-22
 */
public class MapLineTest {
    MapLine mapLine;

    @BeforeEach
    void setUp() {
        mapLine = new MapLine();
    }

    @Test
    void create_확인 () {
        assertThat(mapLine).isEqualTo(new MapLine());
    }

    @Test
    void create_초기값_확인() {
        assertFalse(mapLine.get(0));
    }

    @Test
    void crete_초기값_경계값_확인() {
        assertFalse(mapLine.get(24));
    }

    @Test
    void create_초기값_라인_크기_확인() {
        assertThat(mapLine.size()).isEqualTo(25);
    }
}
