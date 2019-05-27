package coord.model.figure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineTest {
    @Test
    void lengthTest() {
        assertThat(new Line(new Point(1, 4), new Point(6, 19)).length()).isCloseTo(15.8113883, offset(0.0000001));
    }

    @Test
    void gradientTest() {
        assertThat(new Line(new Point(1, 4), new Point(2, 8)).gradient()).isCloseTo(4.0, offset(0.0000001));
    }

    @Test
    void sortTestA() {
        assertThat(new Line(new Point(4, 8), new Point(2, 3)).p().x()).isEqualTo(2);
    }

    @Test
    void sortTestB() {
        assertThat(new Line(new Point(15, 5), new Point(10, 10)).p().x()).isEqualTo(10);
    }

    @Test
    void inclusionTestA() {
        assertThat(new Line(new Point(1, 2), new Point(4, 8)).includes(new Point(2, 4))).isTrue();
    }

    @Test
    void inclusionTestB() {
        assertThat(new Line(new Point(4, 8), new Point(1, 2)).includes(new Point(2, 4))).isTrue();
    }

    @Test
    void inclusionTestC() {
        assertThat(new Line(new Point(4, 8), new Point(1, 2)).includes(new Point(1, 2))).isTrue();
    }

    @Test
    void connectionTestA()  {
        assertThat(new Line(new Point(0, 0), new Point(20, 20)).isConnectedTo(
                new Line(new Point(0, 0), new Point(2, 7)))
        ).isTrue();
    }

    @Test
    void connectionTestB()  {
        assertThat(new Line(new Point(5, 5), new Point(10, 10)).isConnectedTo(
                new Line(new Point(15, 5), new Point(10, 10)))
        ).isTrue();
    }
}