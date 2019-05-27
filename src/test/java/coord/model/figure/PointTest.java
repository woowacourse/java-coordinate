package coord.model.figure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void isOnTheSameLineWithTestA() {
        assertThat(new Line(new Point(2, 4), new Point(0, 0)).includes(new Point(1, 2))).isTrue();
    }

    @Test
    void isOnTheSameLineWithTestB() {
        assertThat(new Line(new Point(2, 2), new Point(4, 2)).includes(new Point(3, 2))).isTrue();
    }

    @Test
    void isOnTheSameLineWithTestC() {
        assertThat(new Line(new Point(2, 4), new Point(2, 0)).includes(new Point(2, 3))).isTrue();
    }
}