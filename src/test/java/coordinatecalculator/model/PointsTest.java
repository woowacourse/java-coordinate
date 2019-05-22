package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {

    @Test
    void 점_생성_테스트(){
        XPoint xPoint = new XPoint("1");
        YPoint yPoint = new YPoint("1");
//        assertThat(new Point(new XPoint("1"),new YPoint("1"))).isEqualTo(new Point(xPoint, yPoint));
    }
}
