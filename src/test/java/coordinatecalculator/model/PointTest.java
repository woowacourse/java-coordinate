package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {

    @Test
    void 입력값이_잘_들어가는지_테스트() {
        assertDoesNotThrow(() -> new Point("(11,22)"));
    }

    @Test
    void 입력값이_잘못_되었을_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Point("((11),(22))"));
    }
}
