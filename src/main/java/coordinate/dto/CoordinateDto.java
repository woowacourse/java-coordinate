package coordinate.dto;

import coordinate.domain.Board;
import coordinate.domain.Shape;

public class CoordinateDto {
    private final Board board;
    private final Shape shape;

    public CoordinateDto(final Board board, final Shape shape) {
        this.board = board;
        this.shape = shape;
    }

    public Board getBoard() {
        return board;
    }

    public Shape getShape() {
        return shape;
    }
}
