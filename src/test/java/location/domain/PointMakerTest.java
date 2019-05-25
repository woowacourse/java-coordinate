package location.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointMakerTest {

    @Test
    void 점_만들기() {
        assertThat(PointMaker.create("(10,20)-(5,4)")).contains(new Point(10,20), new Point(5,4));
    }
}
