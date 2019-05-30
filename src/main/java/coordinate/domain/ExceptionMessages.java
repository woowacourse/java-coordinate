package coordinate.domain;

public enum ExceptionMessages {
    INVALID_COORDI("유효한 좌표가 아닙니다.");


    private String message;

    private ExceptionMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
