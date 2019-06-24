package com.woowa.coordinate.utils;

import com.woowa.coordinate.domain.Point;
import com.woowa.coordinate.domain.Points;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    @Test
    void 한_개의_Point_유효한_입력_형식_테스트() {
        assertThat(InputParser.point("(1,2)"))
                .isEqualTo(new Points(Collections.singletonList(new Point(1, 2))));
    }

    @Test
    void 두_개의_Point_유효한_입력_형식_테스트() {
        assertThat(InputParser.point("(1,2)-(3,4)"))
                .isEqualTo(new Points(Arrays.asList(
                        new Point(1, 2),
                        new Point(3, 4)
                )));
    }

    @Test
    void 세_개의_Point_유효한_입력_형식_테스트() {
        assertThat(InputParser.point("(1,2)-(3,4)-(5,6)"))
                .isEqualTo(new Points(Arrays.asList(
                        new Point(1, 2),
                        new Point(3, 4),
                        new Point(5, 6)
                )));
    }

    @Test
    void 네_개의_Point_유효한_입력_형식_테스트() {
        assertThat(InputParser.point("(1,2)-(3,4)-(5,6)-(7,8)"))
                .isEqualTo(new Points(Arrays.asList(
                        new Point(1, 2),
                        new Point(3, 4),
                        new Point(5, 6),
                        new Point(7, 8)
                )));
    }

    @Test
    void 유효하지_않은_입력형식_예외처리_대괄호_이용() {
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.point("[1,2]-[3,4]")
        );
    }

    @Test
    void 유효하지_않은_입력형식_예외처리_구분자_슬래시_이용() {
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.point("(1,2)/(3,4)")
        );
    }
}