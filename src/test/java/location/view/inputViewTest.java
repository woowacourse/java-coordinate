package location.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class inputViewTest {
    @Test
    void 정규식_빈값() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkValid("(10,20)-(,24)");
        });
    }

    @Test
    void 정규식_가운데_이중대쉬() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkValid("(10,20)--(10,24)");
        });
    }

    @Test
    void 정규식_끝_대쉬() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkValid("(10,20)-(10,24)-");
        });
    }

    @Test
    void 정규식_네개_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.checkValid("(10,20)-(10,24)-(10,20)-(10,24)-(10,24)");
        });
    }
}
