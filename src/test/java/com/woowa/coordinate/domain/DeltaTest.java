package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeltaTest {
    @Test
    void 동일한_값을_가지는_객체_동등_비교() {
        assertEquals(new Delta(3), new Delta(3));
    }

    @Test
    void sum_메서드_Delta3_더하기_Delta4_는_정수_7() {
        assertThat(new Delta(3).sum(new Delta(4))).isEqualTo(7);
        assertThat(new Delta(4).sum(new Delta(3))).isEqualTo(7);
    }

    @Test
    void multiply_메서드_Delta4_곱하기_Delta2_는_정수_8() {
        assertThat(new Delta(4).multiply(new Delta(2))).isEqualTo(8);
        assertThat(new Delta(2).multiply(new Delta(4))).isEqualTo(8);
    }
}