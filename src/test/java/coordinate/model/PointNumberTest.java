package coordinate.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointNumberTest {

    @Test
    void 좌표숫자_범위검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointNumber(25);
        });
    }
}
