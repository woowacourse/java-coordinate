package coordinate.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private String input = "(1,2)-(3,4)-(5,6)";

    @Test
    void 좌표_분리() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), InputView.inputCoordinate());
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in);
    }
}