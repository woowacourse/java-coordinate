package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {

    @Test
    void 거리_계산_확인_테스트(){
        assertThat(new Distance(new Point("(1,1)"),new Point("(1,6)")).getDistance()).isEqualTo(5);
    }
}
