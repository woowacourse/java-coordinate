package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {

    private Points points;
    private String[] input_points;
    private String[] overlap_input_points;

    @Test
    void 점_생성_테스트() {
        input_points = new String[]{"(1,1)", "(2,2)"};
        points = Points.create(input_points);
        assertThat(points.getPoint(0)).isEqualTo(new Point("(1,1)"));
        assertThat(points.getPoint(1)).isEqualTo(new Point("(2,2)"));
    }

    @Test
    void 중복점_테스트() {
        overlap_input_points = new String[]{"(1,1)", "(1,1)"};
        assertThrows(IllegalArgumentException.class, () ->{
            points = Points.create(overlap_input_points);
        });
    }

}
