package coordinate.domain.validator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PointsValidator {
    private static final int MIN_POINTS = 2;
    private static final int MAX_POINTS = 8;
    private static final int REMAINDER_NUMBER = 2;
    private static final int ZERO = 0;

    /**
     * 숫자가 아닌 값이 들어간 경우 체크하고 반환하는 메서드
     * @param str
     * @return convertPoints
     */
    public static List<Integer> convertPoints(String str) {
        try {
            List<Integer> convertPoints = Arrays.stream(str.split(","))
                    .map(Integer::parseInt)
                    .collect(toList());
            return convertPoints;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 들어있습니다");
        }
    }

    public static void checkPointSize(List<Integer> coordinate) {
        int coordinateSize = coordinate.size();
        if (coordinateSize % REMAINDER_NUMBER != ZERO || coordinateSize < MIN_POINTS || coordinateSize > MAX_POINTS) {
            throw new IllegalArgumentException("유효한 값만 입력해주세요");
        }
    }
}
