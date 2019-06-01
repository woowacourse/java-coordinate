package calculator.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class CanvasLineTest {
    CanvasLine canvasLine;

    @BeforeEach
    void setUp() {
        canvasLine = new CanvasLine();
    }

    @Test
    void create_확인 () {
        assertThat(canvasLine).isEqualTo(new CanvasLine());
    }

    @Test
    void create_초기값_확인() {
        assertFalse(canvasLine.get(0));
    }

    @Test
    void crete_초기값_경계값_확인() {
        assertFalse(canvasLine.get(24));
    }

    @Test
    void create_초기값_라인_크기_확인() {
        assertThat(canvasLine.size()).isEqualTo(25);
    }
}
