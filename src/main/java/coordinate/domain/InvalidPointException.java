package coordinate.domain;

public class InvalidPointException extends RuntimeException {
    public InvalidPointException(String msg) {
        super(msg);
    }
}
