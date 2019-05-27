package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void 포인트_생성_테스트() {
        assertThat(new Point(1, 2)).isEqualTo(new Point(1, 2));
    }

    @Test
    void 두_점의_거리_테스트() {
        Point point = new Point(1, 2);
        assertThat(point.sub(new Point(1, 5))).isEqualTo(3);
    }

    @Test
    void 벡터_구하기_테스트() {
        assertThat(new Point(1, 1).calVector(new Point(2, 1))).isEqualTo(new Point(1, 0));
    }

    @Test
    void 벡터_내적_구하기_테스트() {
        Point firstVector = new Point(1, 0);
        assertThat(firstVector.calDotProduct(new Point(0, 1))).isEqualTo(0);
    }

    @Test
    void 벡터의_합_구하기_테스트() {
        Point pivPoint = new Point(1, 1);
        Point crossPoint = new Point(2, 2);

        Point rightVector = pivPoint.calVector(new Point(2, 1));
        Point topVector = pivPoint.calVector(new Point(1, 2));

        Point calCrossPoint = pivPoint.calCrossPoint(rightVector, topVector);

        assertThat(calCrossPoint).isEqualTo(crossPoint);
    }

    @Test
    void 좌표값이_24를_넘어가는_경우_테스트() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Point(25, 0);
        }).withMessage("좌표는 0부터 24까지만 입력할 수 있습니다");
    }

    @Test
    void 좌표값이_음수가_포함된_경우_테스트() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Point(-1, 0);
        }).withMessage("좌표는 0부터 24까지만 입력할 수 있습니다");
    }
}

