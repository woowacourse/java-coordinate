package coordinate.domain.validator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PointsValidator {
    private static final int MIN_POINTS = 2;
    private static final int MAX_POINTS = 8;
    private static final int REMAINDER_NUMBER = 2;
    private static final int ZERO = 0;
    private static final int COORDINATE_MAX_SIZE = 24;
    private static final int COORDINATE_MIN_SIZE = 0;

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

    /**
     * 포인트 개수 체크 및 좌표 값이 0부터 24에 해당하는지 체크하는 메서드
     * @param coordinate
     */
    public static void validatePoints(List<Integer> coordinate) {
        checkPointSize(coordinate.size());

        for (Integer number : coordinate) {
            checkCoordinateSize(number);
        }
    }

    private static void checkPointSize(int coordinateSize) {
        if (coordinateSize % REMAINDER_NUMBER != ZERO || coordinateSize < MIN_POINTS || coordinateSize > MAX_POINTS) {
            throw new IllegalArgumentException("유효한 값만 입력해주세요");
        }
    }

    private static void checkCoordinateSize(Integer number) {
        if(number < COORDINATE_MIN_SIZE || number > COORDINATE_MAX_SIZE) {
            throw new IllegalArgumentException("좌표는 0부터 24까지만 입력할 수 있습니다");
        }
    }
}
