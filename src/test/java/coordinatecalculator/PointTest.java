package coordinatecalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {
    private final String MSG_LIMIT_OVER = "좌표 범위를 초과하였습니다.";
    private Point p1;
    private Point p2;
    private double distance;

    @Test
    void generatePoint() {
        p1 = new Point(1, 1);
        assertThat(p1.getX()).isEqualTo(1);
        assertThat(p1.getY()).isEqualTo(1);

        p1 = new Point(12, 12);
        assertThat(p1.getX()).isEqualTo(12);
        assertThat(p1.getY()).isEqualTo(12);

        p1 = new Point(24, 24);
        assertThat(p1.getX()).isEqualTo(24);
        assertThat(p1.getY()).isEqualTo(24);
    }

    @Test
    void pointLimitOver() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(25, 0);
        }).withMessage(MSG_LIMIT_OVER);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(0, 25);
        }).withMessage(MSG_LIMIT_OVER);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(-1, 0);
        }).withMessage(MSG_LIMIT_OVER);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(0, -1);
        }).withMessage(MSG_LIMIT_OVER);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(25, 25);
        }).withMessage(MSG_LIMIT_OVER);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Point(-1, -1);
        }).withMessage(MSG_LIMIT_OVER);
    }

    @Test
    void distanceCalc() {
        p1 = new Point(1, 1);
        p2 = new Point(2, 2);
        distance = p1.getDistance(p2);
        assertThat(distance).isEqualTo(1.414, offset(0.001));

        p1 = new Point(1, 1);
        p2 = new Point(11, 11);
        distance = p1.getDistance(p2);
        assertThat(distance).isEqualTo(14.142136, offset(0.001));

        p1 = new Point(2, 3);
        p2 = new Point(6, 12);
        distance = p1.getDistance(p2);
        assertThat(distance).isEqualTo(9.848858, offset(0.001));

        p1 = new Point(1, 1);
        p2 = new Point(24, 12);
        distance = p1.getDistance(p2);
        assertThat(distance).isEqualTo(25.4951, offset(0.001));

        p1 = new Point(24, 12);
        p2 = new Point(16, 18);
        distance = p1.getDistance(p2);
        assertThat(distance).isEqualTo(10, offset(0.001));
    }
}