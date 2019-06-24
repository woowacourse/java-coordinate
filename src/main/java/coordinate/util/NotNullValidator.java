package coordinate.util;

import java.util.List;

public class NotNullValidator {
    public static void validateNotNull(Object o) {
        if (o == null || hasNull(o)) {
            throw new IllegalArgumentException("생성자의 인자에 null이 입력될 수 없습니다.");
        }
    }

    private static boolean hasNull(Object o) {
        return (o instanceof List) && ((List) o).contains(null);
    }
}
