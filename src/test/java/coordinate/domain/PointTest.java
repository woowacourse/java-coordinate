//package coordinate.domain;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
//
//public class PointTest {
//
//    @Test
//    void 점이_24를넘는지_테스트() {
//        assertThatIllegalArgumentException().isThrownBy(() ->{
//            new Point("25","1");
//        });
//    }
//
//    @Test
//    void 점이_음수인지_테스트() {
//        assertThatIllegalArgumentException().isThrownBy(() ->{
//            new Point("-1","20");
//        });
//    }
//
//    @Test
//    void 점이_공백을입력받았는지_테스트() {
//        assertThatIllegalArgumentException().isThrownBy(() ->{
//            new Point("","20");
//        });
//        assertThatIllegalArgumentException().isThrownBy(() ->{
//            new Point("      ","20");
//        });
//    }
//
//    @Test
//    void 점이_문자열을_입력받았는지_테스트() {
//        assertThatIllegalArgumentException().isThrownBy(() ->{
//            new Point("aadsds","20");
//        });
//
//        assertThatIllegalArgumentException().isThrownBy(() ->{
//            new Point("1 ","20");
//        });
//    }
//
//
//}
