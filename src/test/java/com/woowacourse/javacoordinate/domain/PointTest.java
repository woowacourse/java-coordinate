package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.point.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointTest {
    @Test
    void 한_점_정상입력() {
        assertThatCode(() -> new Point(0, 0)).doesNotThrowAnyException();
    }

    @Test
    void 한_점_비정상입력_x_좌표가_범위_밖이면_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Point(25, 24)).withMessage("좌표 입력 범위를 넘어갔습니다");
    }

    @Test
    void 한_점_비정상입력_y_좌표가_범위_밖이면_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Point(24, 25)).withMessage("좌표 입력 범위를 넘어갔습니다");
    }

    @Test
    void 한_점_비정상입력_x_좌표가_음수_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Point(-1, 0)).withMessage("좌표 입력 범위를 넘어갔습니다");
    }

    @Test
    void 한_점_비정상입력_y_좌표가_음수_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Point(0, -1)).withMessage("좌표 입력 범위를 넘어갔습니다");
    }
}
