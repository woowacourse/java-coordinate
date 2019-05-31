package coordinate.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeltaTest {

    Delta delta;

    @BeforeEach
    void setUp() {
        delta = new Delta(3);
    }

    @Test
    void sum() {
        assertThat(delta.sum(new Delta(2)).equals(new Delta(5)));
    }

    @Test
    void multiply() {
        assertThat(delta.multiply(new Delta(2))).isEqualTo(6);
    }

    @AfterEach
    void tearDown() {
        delta = null;
    }
}