package coordinate.domain;

public class OutOfCoordinateException extends RuntimeException {
    public OutOfCoordinateException(String format) {
        super(format);
    }
}
