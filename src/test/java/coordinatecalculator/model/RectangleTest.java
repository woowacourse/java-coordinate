package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    private Points points;
    private String[] input_points;
    private String[] wrong_input_points;

    @Test
    void 직사각형_맞는지_검증_테스트() {
        input_points = new String[]{"(1,1)", "(1,3)", "(2,1)","(2,3)"};
        points = Points.create(input_points);
        assertDoesNotThrow(() -> new Rectangle(points));
    }

    @Test
    void 직사각형이_아닐때_검증_테스트() {
        wrong_input_points = new String[]{"(1,2)", "(1,3)", "(2,1)","(2,3)"};
        points = Points.create(wrong_input_points);

        assertThrows(IllegalArgumentException.class, () ->
                new Rectangle(points)
        );
    }

    @Test
    void 직사각형_넓이_구하는_테스트() {
        input_points = new String[]{"(1,1)", "(1,3)", "(2,1)","(2,3)"};
        points = Points.create(input_points);
        assertThat(new Rectangle(points).getResult()).isEqualTo(2);
    }

}
