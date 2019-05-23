package coord.view;

import coord.model.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    @Test
    void parseTest() {
        assertEquals(Arrays.asList(new Point(1, 2), new Point(3, 4), new Point(5, 6)), Parser.parseCoordinates("(1,2)-(3,4)-(5,6)"));
    }
}