package coordinate.domain;

public abstract class Figure {
    private String resultMessage;

    public Figure(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public abstract double calculateResult();

    public String getResultMessage() {
        return resultMessage;
    }
}
