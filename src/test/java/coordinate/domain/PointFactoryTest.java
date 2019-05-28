package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointFactoryTest {
    @Test
    void 중복된점_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "(1,1)-(1,1)";
            PointFactory.create(input);
        });
    }
}