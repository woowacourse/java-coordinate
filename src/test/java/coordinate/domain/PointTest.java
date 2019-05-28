package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PointTest {
    @Test
    void 포인트_생성_테스트() {
        assertThat(new Point(Scalar.of(1), Scalar.of(2))).isEqualTo(new Point(Scalar.of(1), Scalar.of(2)));
    }

    @Test
    void 유효성_X_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Point(Scalar.of(-1), Scalar.of(3));
        }).withMessage(String.format("X값은 %d ~ %d 입니다", Board.MIN_BOARD_SIZE, Board.MAX_BOARD_SIZE));
    }

    @Test
    void 유효성_Y_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Point(Scalar.of(0), Scalar.of(25));
        }).withMessage(String.format("Y값은 %d ~ %d 입니다", Board.MIN_BOARD_SIZE, Board.MAX_BOARD_SIZE));
    }

    @Test
    void 두_점의_거리_테스트() {
        Point point = new Point(Scalar.of(1), Scalar.of(2));
        assertThat(point.sub(new Point(Scalar.of(1), Scalar.of(5)))).isEqualTo(3);
    }

    @Test
    void 벡터_구하기_테스트() {
        assertThat(new Point(Scalar.of(1), Scalar.of(1)).calVector(new Point(Scalar.of(2), Scalar.of(1))))
                .isEqualTo(new Point(Scalar.of(1), Scalar.of(0)));
    }

    @Test
    void 벡터_내적_구하기_테스트() {
        Point firstVector = new Point(Scalar.of(1), Scalar.of(0));
        assertThat(firstVector.calDotProduct(new Point(Scalar.of(0), Scalar.of(1)))).isEqualTo(Scalar.of(0));
    }

    @Test
    void 벡터의_합_구하기_테스트() {
        Point pivPoint = new Point(Scalar.of(1), Scalar.of(1));
        Point crossPoint = new Point(Scalar.of(2), Scalar.of(2));

        Point rightVector = pivPoint.calVector(new Point(Scalar.of(2), Scalar.of(1)));
        Point topVector = pivPoint.calVector(new Point(Scalar.of(1), Scalar.of(2)));

        Point calCrossPoint = pivPoint.calCrossPoint(rightVector, topVector);

        assertThat(calCrossPoint).isEqualTo(crossPoint);
    }
}

