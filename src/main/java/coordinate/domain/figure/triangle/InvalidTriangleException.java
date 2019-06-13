package coordinate.domain.figure.triangle;

import coordinate.domain.figure.InvalidFigureException;

public class InvalidTriangleException extends InvalidFigureException {
    InvalidTriangleException(String msg) {
        super(msg);
    }
}
