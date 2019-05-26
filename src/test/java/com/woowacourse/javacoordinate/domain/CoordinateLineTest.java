package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.coordinate.CoordinateLine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CoordinateLineTest {
    @Test
    void 한_줄_테스트() {
        Boolean[] line = new Boolean[25];
        line[20] = true;

        CoordinateLine coordinateLine = new CoordinateLine(Arrays.asList(line));

        assertThat(coordinateLine.isMarked(20)).isTrue();
    }

    @Test
    void 생성자에_null_입력되었을_때_예외처리() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new CoordinateLine(null));
    }

    @Test
    void 빈_리스트_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CoordinateLine(Collections.emptyList()));
    }
}
