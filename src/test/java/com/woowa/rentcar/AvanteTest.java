package com.woowa.rentcar;

import com.woowa.rentcar.domain.Avante;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AvanteTest {
    @Test
    void getName() {
        assertThat(new Avante(1).getName()).isEqualTo("Avante");
    }
}