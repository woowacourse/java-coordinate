package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TriangleTest {

    private Points points;
    private String[] input_points;
    private String[] wrong_input_points;

    @Test
    void 삼각형이_맞는지_검증_테스트() {
        input_points = new String[]{"(10,10)", "(14,15)", "(20,8)"};
        points = Points.create(input_points);
        assertDoesNotThrow(() -> new Triangle(points));
    }

    @Test
    void 삼각형이_아닐때_검증_테스트() {
        wrong_input_points = new String[]{"(10,10)", "(11,11)", "(20,8)"};
        points = Points.create(wrong_input_points);
        assertThrows(IllegalArgumentException.class, () ->
                new Triangle(points)
        );
    }

    @Test
    void 삼각형_넓이_구하는_테스트() {

        input_points = new String[]{"(10,10)", "(14,15)", "(20,8)"};
        points = Points.create(input_points);
        assertThat(new Triangle(points).getResult()).isEqualTo(29.0);
    }

}
