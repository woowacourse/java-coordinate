package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private Points points;
    private String[] inputPoints;
    private String[] wrongInputPoints;

    @Test
    void 삼각형이_맞는지_검증_테스트() {
        inputPoints = new String[]{"(10,10)", "(14,15)", "(20,8)"};
        points = new Points(inputPoints);
        assertDoesNotThrow(() -> new Triangle(points));
    }

    @Test
    void 삼각형이_아닐때_검증_테스트() {
        wrongInputPoints = new String[]{"(10,10)", "(11,11)", "(20,8)"};
        points = new Points(wrongInputPoints);
        assertThrows(IllegalArgumentException.class, () ->
                new Triangle(points)
        );
    }

    @Test
    void 삼각형_넓이_구하는_테스트() {
        inputPoints = new String[]{"(10,10)", "(14,15)", "(20,8)"};
        points = new Points(inputPoints);
        assertEquals(28.999,new Triangle(points).getResult(),0.001);
    }
}
