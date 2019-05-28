package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsFactoryTest {
    @Test
    void 중복된점_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "(1,1)-(1,1)";
            PointsFactory.create(input);
        });
    }

    @Test
    void 잘못된_좌표_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "(1)-(1,1)";
            PointsFactory.create(input);
        });
    }
}