package coordinate.domain.figure.rectangle;

import coordinate.domain.figure.InvalidFigureException;

public class InvalidRectangleException extends InvalidFigureException {
    public InvalidRectangleException(String msg) {
        super(msg);
    }
}
