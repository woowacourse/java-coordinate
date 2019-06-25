package com.woowa.rentcar;

import com.woowa.rentcar.domain.Avante;
import com.woowa.rentcar.domain.Distance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AvanteTest {
    @Test
    void getName() {
        assertThat(new Avante(new Distance("1")).getName()).isEqualTo("Avante");
    }
}