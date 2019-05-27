package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ShapeFactoryTest {
    @Test
    void 선이_제대로_반환되는지_테스트() {
        Points points = new Points(Arrays.asList(
                new Point(1, 3),
                new Point(2, 3))
        );
        assertThat(ShapeFactory.create(points) instanceof Line).isEqualTo(true);
    }

    @Test
    void 삼각형이_제대로_반환되는지_테스트() {
        Points points = new Points(Arrays.asList(
                new Point(1, 3),
                new Point(2, 3),
                new Point(1, 2)
        ));
        assertThat(ShapeFactory.create(points) instanceof Triangle).isEqualTo(true);
    }

    @Test
    void 사각형이_제대로_반환되는지_테스트() {
        Points points = new Points(Arrays.asList(
                new Point(1, 3),
                new Point(2, 3),
                new Point(1, 2),
                new Point(2, 2)
        ));
        assertThat(ShapeFactory.create(points) instanceof Rectangle).isEqualTo(true);
    }

    @Test
    void Points가_null_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ShapeFactory.create(null);
        }).withMessage("Points가 null이면 안됩니다");
    }

    @Test
    void Points가_범위_예외_테스트1() {
        Points points = new Points(Arrays.asList(
                new Point(1, 3)
        ));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ShapeFactory.create(points);
        }).withMessage(String.format("Points의 길이는 %d ~ %d 입니다", ShapeFactory.MIN_POINTS_SIZE, ShapeFactory.MAX_POINTS_SIZE));
    }

    @Test
    void Points가_범위_예외_테스트2() {
        Points points = new Points(Arrays.asList(
                new Point(1, 3),
                new Point(2, 3),
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 5)
        ));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            ShapeFactory.create(points);
        }).withMessage(String.format("Points의 길이는 %d ~ %d 입니다", ShapeFactory.MIN_POINTS_SIZE, ShapeFactory.MAX_POINTS_SIZE));
    }
}