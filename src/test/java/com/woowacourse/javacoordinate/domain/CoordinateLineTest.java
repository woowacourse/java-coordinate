package com.woowacourse.javacoordinate.domain;

import com.woowacourse.javacoordinate.domain.coordinate.CoordinateLine;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateLineTest {
    @Test
    void 한_줄_테스트() {
        Boolean[] line = new Boolean[25];
        line[20] = true;

        CoordinateLine coordinateLine = new CoordinateLine(Arrays.asList(line));

        assertThat(coordinateLine.isMarked(20)).isTrue();
    }
}
