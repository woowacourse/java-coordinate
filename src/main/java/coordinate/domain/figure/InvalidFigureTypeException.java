package coordinate.domain.figure;

public class InvalidFigureTypeException extends RuntimeException {
    public InvalidFigureTypeException(String msg) {
        super(msg);
    }
}
