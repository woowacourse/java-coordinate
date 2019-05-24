package coord.view;

public enum ConsoleMessages {
    INPUT_COORDINATE("좌표를 입력하세요."),
    ERR_COORDINATE("잘못된 입력입니다. 다시 입력해주세요."),
    ERR_FIGURE("계산할 수 없는 도형입니다."),
    ERR_POINTS("동일한 점은 입력할 수 없습니다.");

    private String message;

    private ConsoleMessages(String text) {
        this.message = text;
    }

    public String message() {
        return message;
    }
}
