package com.woowa.rentcar;

import com.woowa.rentcar.domain.Distance;
import com.woowa.rentcar.domain.K5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class K5Test {
    @Test
    void getName() {
        assertThat(new K5(new Distance("1")).getName()).isEqualTo("K5");
    }
}