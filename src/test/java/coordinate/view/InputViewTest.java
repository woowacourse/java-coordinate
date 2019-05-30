package coordinate.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 좌표_분리() {
        String input = "(1,2)-(3,4)-(5,6)";
        assertEquals(Arrays.asList("(1,2)", "(3,4)", "(5,6)"), InputView.split(input));
    }
}