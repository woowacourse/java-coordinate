package coordinate.domain;

import coordinate.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PointGeneratorTest {


    @Test
    void 생성() {
        String input = "(1,2)-(3,4)-(5,6)";
        assertEquals(Arrays.asList(new Point(1, 2), new Point(3, 4), new Point(5, 6)),
                PointGenerator.trans(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 좌표_예외1() {
        String input = "(1,2)-(3,4)-(5,";
        assertThrows(IllegalArgumentException.class, () -> PointGenerator.trans(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void 좌표_예외2() {
        String input = "(1,2)(3,4)";
        assertThrows(IllegalArgumentException.class, () -> PointGenerator.trans(Arrays.asList()));
    }
}