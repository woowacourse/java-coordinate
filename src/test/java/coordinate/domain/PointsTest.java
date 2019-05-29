package coordinate.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {
    @Test
    void 점들이_서로_다른지_확인_테스트() {
        List<Point> pointList = Arrays.asList(new Point(1, 3), new Point(1, 3));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Points(pointList);
        }).withMessage("중복된 좌표가 존재합니다");
    }

    @Test
    void 점들이_정렬_상태인지_확인() {
        List<Point> pointArrangeList = Arrays.asList(new Point(1, 3), new Point(3, 5),
                new Point(5, 5), new Point(1, 6));
        List<Point> pointNotArrangeList = Arrays.asList(new Point(3, 5), new Point(1, 3),
                new Point(1, 6), new Point(5, 5));
        assertThat(new Points(pointNotArrangeList)).isEqualTo(new Points(pointArrangeList));
    }

    @Test
    void 점들이_제대로_생성되었는지_확인() {
        String inputPoints = "(10,10)-(22,10)-(22,18)-(10,18)";
        Points points = new Points(inputPoints);
        assertThat(points).isEqualTo(new Points(inputPoints));
    }

    @Test
    void 점의_개수가_2개_미만인_경우_테스트() {
        String inputPoints = "(10)";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Points(inputPoints);
        }).withMessage("유효한 값만 입력해주세요");
    }

    @Test
    void 점의_개수가_8개_초과한_경우_테스트() {
        String inputPoints = "(10,10)-(12,3)-(2,4)-(4,5)-(9,2)";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Points(inputPoints);
        }).withMessage("유효한 값만 입력해주세요");
    }

    @Test
    void 점의_개수가_홀수인_경우_테스트() {
        String inputPoints = "(10,2)-(5,8)-(9)";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Points(inputPoints);
        }).withMessage("유효한 값만 입력해주세요");
    }

    @Test
    void 숫자가_아닌_경우_테스트() {
        String inputPoints = "(10,2)-(5,8)-(9,x)";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Points(inputPoints);
        }).withMessage("숫자가 아닌 값이 들어있습니다");
    }
}
