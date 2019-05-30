package coordinate.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private String input = "(1,2)-(3,4)-(5,6)";

    @Test
    void 좌표_분리() {
        assertEquals(Arrays.asList("(1,2)", "(3,4)", "(5,6)"), InputView.split(input));
    }

    @Test
    void 좌표_숫자로_변환() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), InputView.parse(input));
    }
}