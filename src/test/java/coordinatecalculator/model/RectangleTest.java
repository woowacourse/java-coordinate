package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    private Points points;
    private String[] inputPoints;
    private String[] wrongInputPoints;

    @Test
    void 직사각형_맞는지_검증_테스트() {
        inputPoints = new String[]{"(1,1)", "(1,3)", "(2,1)","(2,3)"};
        points = Points.create(inputPoints);
        assertDoesNotThrow(() -> new Rectangle(points));
    }

    @Test
    void 직사각형이_아닐때_검증_테스트() {
        wrongInputPoints = new String[]{"(1,2)", "(1,3)", "(2,1)","(2,3)"};
        points = Points.create(wrongInputPoints);

        assertThrows(IllegalArgumentException.class, () ->
                new Rectangle(points)
        );
    }

    @Test
    void 직사각형_넓이_구하는_테스트() {
        inputPoints = new String[]{"(1,1)", "(1,3)", "(2,1)","(2,3)"};
        points = Points.create(inputPoints);
        assertEquals(2.0,new Rectangle(points).getResult(),0.001);
    }

}
