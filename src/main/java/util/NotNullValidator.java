package util;

public class NotNullValidator {
    public static void validateNotNull(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("생성자의 인자에 null이 입력될 수 없습니다.");
        }
    }
}
