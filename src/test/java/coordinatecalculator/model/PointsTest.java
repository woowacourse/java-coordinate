package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {
    private Points points;
    private String[] inputPoints;
    private String[] overlapInputPoints;

    @Test
    void 점_생성_테스트() {
        inputPoints = new String[]{"(1,1)", "(2,2)"};
        points = Points.create(inputPoints);
        assertThat(points.getPoint(0)).isEqualTo(new Point("(1,1)"));
        assertThat(points.getPoint(1)).isEqualTo(new Point("(2,2)"));
    }

    @Test
    void 중복점_테스트() {
        overlapInputPoints = new String[]{"(1,1)", "(1,1)"};
        assertThrows(IllegalArgumentException.class, () ->{
            points = Points.create(overlapInputPoints);
        });
    }

}
