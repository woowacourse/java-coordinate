package com.woowa.rentcar;

import com.woowa.rentcar.domain.Distance;
import com.woowa.rentcar.domain.Sonata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SonataTest {
    @Test
    void getName() {
        assertThat(new Sonata(new Distance("1")).getName()).isEqualTo("Sonata");
    }
}