package coordinate.domain;

public enum ErrMessages {
    INVALID_COORDI("유효한 좌표가 아닙니다.");


    private String message;

    private ErrMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
