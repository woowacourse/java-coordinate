package coord.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void lengthTest() {
        double RESULT = 15.811;
        assertEquals(RESULT, new Line(new Points(Arrays.asList(new Point(1, 4), new Point(6, 19)))).length(),0.001);
    }
}