package coordinate.domain.figure;

public class InvalidFigureException extends RuntimeException{
    public InvalidFigureException(String msg) {
        super(msg);
    }
}
