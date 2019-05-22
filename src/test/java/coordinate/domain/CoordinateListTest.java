package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CoordinateListTest {

    @Test
    void 중복좌표테스트() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CoordinateList(Arrays.asList(new Coordinate(new X("0"), new Y("0")),
                    new Coordinate(new X("0"), new Y("0")),
                    new Coordinate(new X("0"), new Y("0")),
                    new Coordinate(new X("0"), new Y("0"))));
        });
    }
}
